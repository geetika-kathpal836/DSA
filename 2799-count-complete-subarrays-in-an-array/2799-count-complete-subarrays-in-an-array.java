class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> st=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            st.add(nums[i]);
        }
        int distinctele=st.size();
        int firstval=lessthanequaltok(nums,distinctele);
        int secondval=lessthanequaltok(nums,distinctele-1);
        return firstval-secondval; 
    }
    public int lessthanequaltok(int[] nums, int k){
        HashMap<Integer, Integer> mpp=new HashMap<>();
        int l=0;
        int r=0;
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