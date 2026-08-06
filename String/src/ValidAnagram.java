public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        int m = s.length();
        int n = t.length();

        if(m!=n){
            return false;
        }

        int ar[] = new int[26];

        for(int i = 0;i<m;i++){
            ar[s.charAt(i)-'a']++;
        }

        for(int i = 0;i<n;i++){
            ar[t.charAt(i)-'a']--;
            if(ar[t.charAt(i)-'a']<0){
                return false;
            }
        }
        return true;



    }
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s,t));
    }
}
