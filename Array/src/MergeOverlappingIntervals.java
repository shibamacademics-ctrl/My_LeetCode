import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervals {
    public static int[][] merge(int[][] ar){
        int n = ar.length;
        Arrays.sort(ar,(a,b)->Integer.compare(a[0],b[0]));
        List<int []> ans = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(ans.isEmpty() || ar[i][0] > ans.get(ans.size() - 1)[1]){
                ans.add(ar[i]);
            }
            else{
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1],ar[i][1]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        int intervals[] [] = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println("Merged Intervals are: " + Arrays.deepToString(merge(intervals)));
    }
}
