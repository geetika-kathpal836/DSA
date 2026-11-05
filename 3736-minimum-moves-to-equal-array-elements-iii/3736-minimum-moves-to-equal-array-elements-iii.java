class Solution {
    public int minMoves(int[] nums) {
        int target=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            target=Math.max(target,nums[i]);
            sum+=nums[i];
        }
        return (target*nums.length)-sum;
    }
}