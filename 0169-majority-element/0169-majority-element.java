class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> mpp=new HashMap<>();
        int x=-1;
        for(int i=0;i<nums.length;i++){
            if(mpp.containsKey(nums[i])){
                mpp.put(nums[i],mpp.get(nums[i])+1);
                if(mpp.get(nums[i])>(n/2)){
                    x=nums[i];
                    break;
                }
            }else{
                mpp.put(nums[i],1);
                if(mpp.get(nums[i])>(n/2)){
                    x=nums[i];
                    break;
                }
            }
        }
        return x;
    }
}