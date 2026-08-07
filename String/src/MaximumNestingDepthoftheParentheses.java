public class MaximumNestingDepthoftheParentheses {
    public static int maxDepth(String s) {
        int count = 0;
        int max = Integer.MIN_VALUE;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                count++;
            }
            else if(ch == ')'){
                count--;
            }
            max = Math.max(max,count);
        }
        return max;
    }
    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println("Maximum Depth is:"+maxDepth(s));
    }
}
