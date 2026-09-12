import java.util.HashMap;

public class FruitIntoBasket {
    public static int totalFruit(int ar[]){
        HashMap<Integer,Integer> map= new HashMap<>();
        int l = 0;
        int maxLen = 0;
        for(int r = 0;r<ar.length;r++){
            map.put(ar[r],map.getOrDefault(ar[r],0)+1);
            while(map.size()>2) {
                map.put(ar[l], map.get(ar[l]) - 1);

                if (map.get(ar[l]) == 0) {
                    map.remove(ar[l]);
                }
                l++;
            }
            maxLen = Math.max(maxLen,r-l+1);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int ar[] = {1,2,3,2,2};
        System.out.println("Total Fruit is: "+totalFruit(ar));
    }
}
