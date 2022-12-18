package TestTask2.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import org.junit.Test;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.util.Map;
import java.util.logging.Logger;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

/*
 Go to https://freegeoip.io/ and get a free API key (be aware that it is limited to 100 requests / mo). Call their API with that key, using JSON format, and perform the following actions:
a) Assert the response code;
b) Assert your latitude and longitude with a 0.01° tolerance.
 */


public class ApiTests {

    public static String baseURL = RestAssured.baseURI = "http://api.ipstack.com/134.201.250.155";
    private final static Logger LOG = Logger.getLogger("ApiTests");
    private static double expectedLatitude = 34.0655517578125;
    private static double expectedLongitude = -118.24053955078125;

    public static JSONObject transformResponseStructureToJsonFormat(String responseBody) throws JSONException {
        String responseBodyWithoutFunction = responseBody.substring(responseBody.indexOf("(") + 1, responseBody.lastIndexOf(")"));
        JSONObject jsonObject = new JSONObject(responseBodyWithoutFunction);
        return jsonObject;
    }

    @Test
    public void assertStatusCodeTest() {
        int actualStatusCode = given()
                .contentType(ContentType.JSON)
                .params(Map.of("access_key", "fc2dc368226bf44f6661cb3e9b35cd85", "callback", "MY_FUNCTION"))
                .log().all()
                .when()
                .request(Method.GET)
                .getStatusCode();
        assertEquals("Request was not successful", 200, actualStatusCode);
        LOG.info("Request was successful");
    }

    @Test
    public void assertLatitudeAndLongitudeWithAToleranceTest() throws JSONException {

       JSONObject responseBody = transformResponseStructureToJsonFormat(given()
               .contentType(ContentType.JSON)
               .params(Map.of("access_key", "fc2dc368226bf44f6661cb3e9b35cd85", "callback", "MY_FUNCTION"))
               .log().all()
               .when()
               .request(Method.GET)
               .body().asString());

        double actualLatitude = Double.parseDouble(responseBody.get("latitude").toString());
        double actualLongitude = Double.parseDouble(responseBody.get("longitude").toString());

        assertEquals(expectedLatitude, actualLatitude, 0.01);
        LOG.info("Latitude field value is correct");

        assertEquals(expectedLongitude, actualLongitude, 0.01);
        LOG.info("Longitude field value is correct");
    }
}
