public class FloorandCeil {

    public static int[] getFloorAndCeil(int[] arr, int x) {
        int floor = -1;
        int ceil = -1;

        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                floor = arr[mid];
                ceil = arr[mid];
                return new int[]{floor, ceil};
            } else if (arr[mid] < x) {
                floor = arr[mid];   // Possible floor
                low = mid + 1;
            } else {
                ceil = arr[mid];    // Possible ceil
                high = mid - 1;
            }
        }

        return new int[]{floor, ceil};
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 10, 12, 14};
        int x = 5;

        int[] ans = getFloorAndCeil(arr, x);

        System.out.println("Floor: " + ans[0]);
        System.out.println("Ceil: " + ans[1]);
    }
}