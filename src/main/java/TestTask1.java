public class TestTask1 {
    /*
    Є масив з відстанями між містами.
    Написати метод, який виводить мінімальну відстань між
    2ма містами
    */

    static int task(int[] arr) {
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (Math.abs(arr[i] - arr[j]) < diff) {
                    diff = Math.abs(arr[i] - arr[j]);
                }
            }
        }
        return diff;
    }

    public static void main(String[] args) {
        int[] arr = {5, 11, 7, 20};
        System.out.println(task(arr));
    }
}

