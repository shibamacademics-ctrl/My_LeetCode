public class LargestOddNumberInString {
    public static String odd(String s){
        for(int i = s.length() - 1;i>=0;i--){
            int digit = s.charAt(i) - '0';
            if(digit%2 == 1){
                return s.substring(0,i+1);
            }
        }
        return "";
    }
    public static void main(String[] args) {
        String num = "52";
        System.out.println("Largest odd number is:"+odd(num));
    }
}
