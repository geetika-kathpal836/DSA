class Solution {
    public int reverse(int x) {
        long xx=x;
        int sign=1;
        if(xx<0){
            sign=-1;
            xx=-xx;
        }
        long rev=0;
        while(xx>0){
            long ld=xx%10;
            rev=(rev*10)+ld;
            xx=xx/10;
        }
        if(sign*rev<Integer.MIN_VALUE) return 0;
        if(sign*rev>Integer.MAX_VALUE) return 0;
        return (int)(sign*rev);
    }
}