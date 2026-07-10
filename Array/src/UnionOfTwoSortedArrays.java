import java.util.ArrayList;

public class UnionOfTwoSortedArrays {
    public static int[] Union(int ar1[],int ar2[]){
        int n1 = ar1.length;
        int n2 = ar2.length;
        ArrayList<Integer> union = new ArrayList<>();
        int i = 0,j = 0;
        while(i<n1 && j<n2){
            if(ar1[i]<=ar2[j]){
                if (union.size() == 0 || union.get(union.size()-1)!= ar1[i]) {
                    union.add(ar1[i]);
                }
                i++;
            }
            else{
                if (union.size() == 0 || union.get(union.size()-1)!= ar2[j]) {
                    union.add(ar2[j]);
                }
                j++;
            }
        }
        while(i<n1){
            if (union.size() == 0 || union.get(union.size()-1)!= ar1[i]) {
                union.add(ar1[i]);
            }
            i++;
        }
        while(j<n2){
            if (union.size() == 0 || union.get(union.size()-1)!= ar2[j]) {
                union.add(ar2[j]);
            }
            j++;
        }
        int[] result = new int[union.size()];
        for (int k = 0; k < union.size(); k++) {
            result[k] = union.get(k);
        }

        return result;

    }
    public static void main(String[] args) {
        int[] ar1 = {1, 2, 2, 3, 4};
        int[] ar2 = {2, 3, 5, 6};

        int[] ans = Union(ar1, ar2);

        for (int x : ans) {
            System.out.print(x + " ");
        }
    }
}
