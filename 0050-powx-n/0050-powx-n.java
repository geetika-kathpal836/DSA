class Solution {
    public double myPow(double x, int n) {
        if(x==1 || n==0) return 1;
        if(x==0) return 0;
        if(n==1) return x;
        long nn=n;
        if(nn<0) return 1/helper(x,-nn);
        return helper(x,nn);
    }
    public double helper(double x, long nn){
        if(nn==0) return 1.0;
        if(nn==1) return x;
        if(nn%2==0) return helper(x*x,nn/2);
        return x* helper(x,nn-1);
    }
}