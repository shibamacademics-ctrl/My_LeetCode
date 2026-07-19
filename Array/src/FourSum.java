import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static List<List<Integer>> foursum(int ar[],int target){
        int n = ar.length;
        Arrays.sort(ar);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(i>0 && ar[i] == ar[i-1]){
                continue;
            }
            for(int j = i+1;j<n;j++){
                if(j!=i+1 && ar[j] == ar[j-1]){
                    continue;
                }
                int k = j+1;
                int l = n - 1;
                while(k<l){
                    long sum = ar[i] + ar[j] + ar[k] + ar[l];
                    if(sum == target){
                        ans.add(Arrays.asList(ar[i],ar[j],ar[k],ar[l]));
                        k++;
                        l--;
                        while(k<l && ar[k] == ar[k-1])
                            k++;
                        while(k<l && ar[l] == ar[l-1])
                            l--;
                    }
                    else if(sum<target){
                        k++;
                    }
                    else{
                        l--;
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int ar[] = {1,0,-1,0,-2,2};
        System.out.println("Four Sum will be:"+foursum(ar,0));
    }
}
