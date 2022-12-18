package TestTask2;

public class LocationInfoPojo {
    private String ip;
    private String type;
    private String continent_code;
    private String continent_name;
    private String country_code;
    private String country_name;
    private String region_code;
    private String region_name;
    private String city;
    private String zip;
    private double latitude;
    private double longitude;

    public LocationInfoPojo() {
    }

    public LocationInfoPojo(String ip, String type, String continent_code, String continent_name, String country_code, String country_name, String region_code, String region_name, String city, String zip, double latitude, double longitude) {
        this.ip = ip;
        this.type = type;
        this.continent_code = continent_code;
        this.continent_name = continent_name;
        this.country_code = country_code;
        this.country_name = country_name;
        this.region_code = region_code;
        this.region_name = region_name;
        this.city = city;
        this.zip = zip;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
