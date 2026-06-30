class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        boolean[] isprime =checkprime(n);
        List<List<Integer>> ans=new ArrayList<>();
        int k=0;
        for(int i=2;i<=n/2;i++){
            if(isprime[i] && isprime[n-i]){
                ans.add(new ArrayList<Integer>());
                ans.get(k).add(i);
                ans.get(k).add(n-i);
                k++;
            }
        }
        return ans;
    }
    private boolean[] checkprime(int n){
        boolean[] isprime=new boolean[n+1];
        for(int i=2;i<n+1;i++){
            isprime[i]=true;
        }
        for(int i=2;i*i<=n;i++){
            if(isprime[i]){
                for(int j=i*i;j<=n;j+=i){
                    isprime[j]=false;
                }
            }
        }
        return isprime;
    }
}