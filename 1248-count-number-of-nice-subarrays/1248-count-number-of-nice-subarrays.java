class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int solvefork=prefixfork(nums,k);
        int solveforkminus1=prefixforkminus1(nums,k-1);
        return solvefork-solveforkminus1;
    }
    public int prefixfork(int[] nums,int k){
        int l=0;
        int r=0;
        int cnt=0;
        int sum=0;
        while(r<nums.length){
            sum+=nums[r]%2;
            while(sum>k){
                sum=sum-(nums[l]%2);
                l++;
            }
            if(sum<=k){
                cnt+=r-l+1;
            }
            r++;
        }
        return cnt;
    }
    public int prefixforkminus1(int[] nums, int k){
        int l=0;
        int r=0;
        int cnt=0;
        int sum=0;
        while(r<nums.length){
            sum+=nums[r]%2;
            while(sum>k){
                sum=sum-(nums[l]%2);
                l++;
            }
            if(sum<=k){
                cnt+=r-l+1;
            }
            r++;
        }
        return cnt;
    }
}