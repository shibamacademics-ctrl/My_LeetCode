public class LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String s,int k){
        int l = 0;
        int maxLen = 0;
        int mmf = 0;
        int freq[] = new int[26];
        for(int r = 0;r<s.length();r++){
            freq[s.charAt(r) - 'A']++;
            mmf = Math.max(mmf,freq[s.charAt(r)-'A']);
            while((r-l+1) - mmf > k){
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            maxLen = Math.max(maxLen,r-l+1);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println("Length is:"+characterReplacement(s,k));
    }
}
