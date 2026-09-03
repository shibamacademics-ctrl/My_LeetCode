import java.util.*;
class AsteroidCollisions {
    public static int[] collisions(int ar[]){
        Stack<Integer> st = new Stack<>();
        int n = ar.length;
        for(int i = 0;i<n;i++){
            if(ar[i]>0){
                st.push(ar[i]);
            }
            else{
                while(!st.isEmpty() && st.peek()>0 && st.peek()<ar[i]){
                    st.pop();
                }
                if(!st.isEmpty() && st.peek() == ar[i]){
                    st.pop();
                    continue;
                }
                if(st.isEmpty() || st.peek()<0){
                    st.push(ar[i]);
                }
            }
        }
        int res[] = new int[st.size()];
        for(int i = res.length - 1;i>=0;i--){
            res[i] = st.pop();
        }
        return res;
    }
    public static void main(String[] args) {
        int ar[] = {3,5,-6,2,-1,4};
        System.out.println("Never Collide Asteroids are:"+Arrays.toString(collisions(ar)));
    }
}
