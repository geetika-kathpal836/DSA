class Solution {
    public int longestSubarray(int[] nums) {
        int maxlen=0;
        int l=0;
        int r=0;
        boolean zerofound=false;
        boolean onefound=false;
        int cntzero=0;
        while(r<nums.length){
            if(nums[r]==0){
                zerofound=true;
                cntzero+=1;
            }else{
                onefound=true;
            }
            if(zerofound==true && cntzero>1){
                if(nums[l]==0) cntzero--;
                l++;
            }
            int len=r-l+1;
            maxlen=Math.max(maxlen,len);
            r++;
        }
        return (onefound==true)?maxlen-1:0;
    }
}