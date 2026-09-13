class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int first=subarrayWithKDistinct(nums,k);
        int second=subarrayWithKminus1Distinct(nums,k-1);
        return first-second;
    }
    public int subarrayWithKDistinct(int[] nums, int k){
        int l=0;
        int r=0;
        HashMap<Integer, Integer> mpp=new HashMap<>();
        int cnt=0;
        while(r<nums.length){
            if(mpp.containsKey(nums[r])){
                mpp.put(nums[r],mpp.get(nums[r])+1);
            }else{
                mpp.put(nums[r],1);
            }
            while(mpp.size()>k){
                mpp.put(nums[l],mpp.get(nums[l])-1);
                if(mpp.get(nums[l])==0){
                    mpp.remove(nums[l]);
                }
                l++;
            }
            cnt+=r-l+1;
            r++;
        }
        return cnt;
    }
    public int subarrayWithKminus1Distinct(int[] nums, int k){
        int l=0;
        int r=0;
        HashMap<Integer, Integer> mpp=new HashMap<>();
        int cnt=0;
        while(r<nums.length){
            if(mpp.containsKey(nums[r])){
                mpp.put(nums[r],mpp.get(nums[r])+1);
            }else{
                mpp.put(nums[r],1);
            }
            while(mpp.size()>k){
                mpp.put(nums[l],mpp.get(nums[l])-1);
                if(mpp.get(nums[l])==0){
                    mpp.remove(nums[l]);
                }
                l++;
            }
            cnt+=r-l+1;
            r++;
        }
        return cnt;
    }
}