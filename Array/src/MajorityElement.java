public class MajorityElement {
    public static int count(int ar[]){
        int count = 0;
        int el = 0;
        int n = ar.length;
        for(int i = 0;i<n;i++){
            if(count == 0){
                count = 1;
                el = ar[i];
            }
            else if(ar[i] == el){
                count++;
            }
            else{
                count--;
            }
        }
        int count1 = 0;
        for(int i = 0;i<n;i++){
            if(ar[i] == el)
                count1++;
        }
        if(count1 > n/2){
            return el;
        }
        return -1;
    }
    public static void main(String[] args) {
        int ar [] = {2,2,1,1,1,2,2};
        System.out.println("Majority element is: "+count(ar));
    }
}
