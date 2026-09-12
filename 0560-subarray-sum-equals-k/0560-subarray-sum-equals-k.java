class Solution {
    public int subarraySum(int[] nums, int k) {
        int cnt=0;
        int prefixsum=0;
        HashMap<Integer,Integer> mpp=new HashMap<>();
        mpp.put(0,1);
        for(int i=0;i<nums.length;i++){
            prefixsum+=nums[i];
            int remove=prefixsum-k;
            if(mpp.containsKey(remove)){
                cnt+=mpp.get(remove);
            }
            if(mpp.containsKey(prefixsum)){
                mpp.put(prefixsum,mpp.get(prefixsum)+1);
            }
            else{
                mpp.put(prefixsum,1);
            }
        }
        return cnt;
    }
}