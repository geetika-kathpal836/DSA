class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> mpp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            mpp.put(nums[i],mpp.getOrDefault(nums[i],0)+1);
        }
        ArrayList<Integer> arrl=new ArrayList<>(mpp.keySet());
        Collections.sort(arrl,(a,b)->mpp.get(b)-mpp.get(a));
        int[] ans=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=arrl.get(i);
        }
        return ans;
    }
}
