import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LeadersInArray {
    public static int[] leaders(int ar[]){
        int n = ar.length;
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = n-1;i>=0;i--){
            if(max<ar[i]){
                ans.add(ar[i]);
                max = ar[i];
            }
        }
        Collections.reverse(ans);
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;
    }
    public static void main(String args[]){
        int[] arr = {16, 17, 4, 3, 5, 2};
        System.out.println("Leaders Are: "+ Arrays.toString(leaders(arr)));
    }
}
