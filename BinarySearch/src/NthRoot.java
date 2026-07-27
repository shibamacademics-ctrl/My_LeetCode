public class NthRoot {
    static int check(long mid, int n, int m) {
        long ans = 1;

        for (int i = 0; i < n; i++) {
            ans *= mid;


            if (ans > m) {
                return 2;
            }
        }

        if (ans == m) {
            return 0;
        } else if (ans < m) {
            return 1;
        } else {
            return 2;
        }
    }

    static int nthRoot(int n, int m) {
        long low = 1, high = m;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            int res = check(mid, n, m);

            if (res == 0) {
                return (int) mid;
            } else if (res == 1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 27;

        System.out.println(nthRoot(n, m)); // Output: 3
    }
}