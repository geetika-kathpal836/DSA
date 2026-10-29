class Solution {
    public int mySqrt(int x) {
        if(x==1 || x==0) return x;
        long i=1;
        while(i*i<=x){
            i++;
        }
        return (int)(i-1);
    }
}