import java.util.ArrayList;
import java.util.Arrays;

public class AlternateNumbers {
    public static int[] alternate(int ar[]) {
        int n = ar.length;
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (ar[i] < 0) {
                neg.add(ar[i]);
            } else {
                pos.add(ar[i]);
            }
        }
        if(pos.size()>neg.size()){
            for(int i = 0;i<neg.size();i++){
                ar[2*i] = pos.get(i);
                ar[2*i+1] = neg.get(i);
            }
            int index = neg.size() * 2;
            for(int i = neg.size();i<pos.size();i++){
                ar[index] = pos.get(i);
                index++;
            }
        }
        else{
            for(int i = 0;i<pos.size();i++){
                ar[2*i] = pos.get(i);
                ar[2*i+1] = neg.get(i);
            }
            int index = pos.size() * 2;
            for(int i = pos.size();i<neg.size();i++){
                ar[index] = neg.get(i);
                index++;
            }
        }
        return ar;
    }

    public static void main(String[] args) {
        int ar[] = {3, 1, -2, -5, 2, -4,6,1};
        System.out.println("Alternate number is: "+Arrays.toString(alternate(ar)));
    }
}