class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> mpp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            mpp.put(nums[i],i);
        }
        int[] ans=new int[2];
        for(int i=0;i<nums.length;i++){
            if(mpp.containsKey(target-nums[i])){
                int x=mpp.get(target-nums[i]);
                if(x!=i){
                    if(x<i){
                        ans[0]=x;
                        ans[1]=i;
                    }else{
                        ans[1]=x;
                        ans[0]=i;
                    }
                }
            }
        }
        return ans;
    }
}