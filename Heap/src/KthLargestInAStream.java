import java.util.*;
public class KthLargestInAStream {
    static class Kthlargest {
        int k;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        Kthlargest(int k, int[] ar) {
            this.k = k;
            for (int ele : ar) {
                pq.add(ele);
                if (pq.size() > k) pq.remove();
            }
        }

        public int add(int val) {
            if (pq.size() < k) {
                pq.add(val);
                return pq.peek();
            }
            pq.add(val);
            pq.remove();
            return pq.peek();
        }


    }

    public static void main(String[] args) {
        int k = 3;
        int[] ar = {4, 5, 8, 2};

        System.out.println("Initializing KthLargest with k = " + k + " and initial stream = [4, 5, 8, 2]");
        Kthlargest kthLargest = new Kthlargest(k, ar);


        int[] streamInputs = {3, 5, 10, 9, 4};

        // Execute and print results for each stream addition
        for (int val : streamInputs) {
            int result = kthLargest.add(val);
            System.out.println("Added: " + val + " -> 3rd Largest is: " + result);
        }
    }
}
