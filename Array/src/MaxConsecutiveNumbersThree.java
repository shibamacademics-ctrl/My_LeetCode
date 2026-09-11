class MaxConsecutiveNumbersThree {
    public static int length(int nums[],int k){
        int l = 0,r = 0;
        int maxLen = 0,zeroes = 0;
        while(r<nums.length){
            if(nums[r] == 0){
                zeroes++;
            }
            if(zeroes>k){
                if(nums[l] == 0){
                    zeroes--;
                }
                l++;
            }
            if(zeroes<=k){
                int len = r-l+1;
                maxLen = Math.max(len,maxLen);
            }
            r++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int nums[] = {1,1,1,0,0,0,1,1,1,0};
        int k = 2;
        System.out.println("Length is: "+length(nums,k));
    }
}
