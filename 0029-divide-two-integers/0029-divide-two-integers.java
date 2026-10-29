class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor==-1){
            return Integer.MAX_VALUE;
        }
        long a=Math.abs((long)dividend);
        long b=Math.abs((long) divisor);
        
        boolean neg=(divisor<0) ^ (dividend<0);   //false ayega toh means the ans is not negative.

        long quotient=0;   //this is our ans.
        while(a>=b){
            long temp=b;
            long multiple=1;
            while(a>=(temp<<1)){
                temp=temp<<1;
                multiple=multiple<<1;
            }
            quotient=quotient+multiple;
            a=a-temp;
        }
        if(neg) return (int) -quotient;
        return (int)quotient;
    }
}