import java.util.*;
public class KClosestPair {
        public static int[][] kClosest(int[][] points, int k) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((e1,e2) -> Integer.compare(e2[0],e1[0]));

            for(int i = 0;i<points.length;i++){
                int[] point = points[i];

                int x = point[0], y = point[1];

                int dist = (x*x) + (y*y);
                pq.add(new int[] {dist,i});

                if(pq.size()>k){
                    pq.poll();
                }
            }
            int res[][] = new int[k][2];
            int i = 0;
            while(i<k){
                int ele[] = pq.poll();

                int dist = ele[0] , idx = ele[1];

                res[i][0] = points[idx][0];
                res[i][1] = points[idx][1];
                i++;
            }

            return res;


        }

    public static void main(String[] args) {


        int[][] points = {
                {1, 3},
                {-2, 2},
                {5, 8},
                {0, 1}
        };

        int k = 2;

        int[][] ans = KClosestPair.kClosest(points, k);

        for (int[] p : ans) {
            System.out.println(Arrays.toString(p));
        }
    }
}

