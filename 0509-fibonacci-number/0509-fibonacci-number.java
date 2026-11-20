class Solution {
    public int fib(int n) {
        int prev2=0;
        int prev=1;
        if(n<=1) return n;
        int ans=n;
        for(int i=2;i<=n;i++){
            ans=prev+prev2;
            prev2=prev;
            prev=ans;
        }
        return ans;
    }
}