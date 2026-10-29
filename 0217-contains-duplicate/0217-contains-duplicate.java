class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> st=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(st.contains(nums[i])){
                return true;
            }
            st.add(nums[i]);
        }
        return false;
    }
}