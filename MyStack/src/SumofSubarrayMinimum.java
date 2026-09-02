class SumofSubarrayMinimum {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long MOD = 1_000_000_007;

        int[] pse = new int[n];
        int[] nse = new int[n];

        int[] stack = new int[n];
        int top = -1;
        for (int i = 0; i < n; i++) {

            while (top >= 0 && arr[stack[top]] >= arr[i]) {
                top--;
            }

            pse[i] = (top == -1) ? -1 : stack[top];

            stack[++top] = i;
        }

        top = -1;
        for (int i = n - 1; i >= 0; i--) {

            while (top >= 0 && arr[stack[top]] > arr[i]) {
                top--;
            }

            nse[i] = (top == -1) ? n : stack[top];

            stack[++top] = i;
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {

            long left = i - pse[i];
            long right = nse[i] - i;

            long contribution =
                    (arr[i] * left % MOD) * right % MOD;

            ans = (ans + contribution) % MOD;
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};

        SumofSubarrayMinimum obj = new SumofSubarrayMinimum();

        int result = obj.sumSubarrayMins(arr);

        System.out.println("Sum of Subarray Minimums = " + result);
    }
}
