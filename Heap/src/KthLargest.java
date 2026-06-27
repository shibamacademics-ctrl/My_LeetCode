import java.util.PriorityQueue;

public class KthLargest {
    public static int Largest(int ar[],int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int ele : ar){
            pq.add(ele);
            if(pq.size()>k) pq.remove();
        }
        return pq.peek();
    }

    public static void main(String args[]){
        int ar[] = {7,10,3,4,20,13};
        int k  = 3;

        System.out.println("Kth Smallest Element is: "+Largest(ar,k));
    }
}
