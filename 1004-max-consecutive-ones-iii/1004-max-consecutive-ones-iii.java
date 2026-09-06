class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0;
        int r=0;
        int maxlen=0;
        int zeroes=0;
        while(r<nums.length){
            if(nums[r]==0) zeroes++;
            if(zeroes>k){
                if(nums[l]==0) zeroes--;
                l++;
            }
            int len=r-l+1;
            maxlen=Math.max(maxlen,len);
            r++;
        }
        return maxlen;
    }
}