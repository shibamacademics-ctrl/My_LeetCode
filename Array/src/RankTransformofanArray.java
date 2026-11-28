import java.util.Arrays;
import java.util.HashMap;

class RankTransformofanArray {
    public static int[] arrayRankTransform(int[] ar){
        int sort[] = ar.clone();
        Arrays.sort(sort);
        HashMap<Integer,Integer> map = new HashMap<>();
        int rank = 1;
        for(int num : sort){
            if(!map.containsKey(num)){
                map.put(num,rank++);
            }
        }
        int res[] = new int[ar.length];
        for(int i = 0;i<ar.length;i++){
            res[i] = map.get(ar[i]);
        }
        return res;
    }

    public static void main(String[] args) {

        int ar[] = {40, 10, 20, 30, 10};

        int result[] = arrayRankTransform(ar);

        System.out.println(Arrays.toString(result));
    }
}
