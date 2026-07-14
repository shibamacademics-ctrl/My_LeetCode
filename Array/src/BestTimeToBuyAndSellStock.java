public class BestTimeToBuyAndSellStock {
    public static int max(int ar[]){
        int n = ar.length;
        int buy_price = ar[0];
        int current_profit = 0;
        int max_profit = 0;
        for(int i  = 0;i<n;i++){
            if(buy_price>ar[i]){
                buy_price = ar[i];
            }
            else{
                current_profit = ar[i] - buy_price;
                max_profit = Math.max(max_profit,current_profit);
            }
        }
        return max_profit;
    }
    public static void main(String[] args) {
        int ar[] = {7,1,5,3,6,4};
        System.out.println("Maximum profit is: "+max(ar));
    }
}
