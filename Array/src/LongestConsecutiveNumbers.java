import java.util.HashSet;

public class LongestConsecutiveNumbers {
    public static int longest(int ar[]){
        int longest = 1;
        int n = ar.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i<n;i++){
            set.add(ar[i]);
        }
        for(int ele : set){
            if(!set.contains(ele - 1)) {
                int count = 1;
                int x = ele;
                while (set.contains(x + 1)) {
                    x = x + 1;
                    count++;
                }
                longest = Math.max(longest,count);
            }
        }
        return longest;
    }
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longest(nums));

    }
}
