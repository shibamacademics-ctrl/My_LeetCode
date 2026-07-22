import java.util.*;

public class FindMissingAndRepeatedValues {
    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int expsum = 0,actualsum = 0;
        Set<Integer> set = new HashSet<>();
        int a = 0,b = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<grid[0].length;j++){
                actualsum += grid[i][j];
                if(set.contains(grid[i][j])){
                    a = grid[i][j];
                }
                set.add(grid[i][j]);
            }
        }
        int total = n*n;
        expsum = total*(total+1)/2;
        b = expsum + a -actualsum;
        return new int[]{a,b};
    }
    public static void main(String[] args) {
        int[][] grid = {
                {1, 3},
                {2, 2}
        };

        int[] ans = findMissingAndRepeatedValues(grid);

        System.out.println("Repeated: " + ans[0]);
        System.out.println("Missing: " + ans[1]);
    }
}
