class Solution {
    public int titleToNumber(String columnTitle) {
        int ans=0;
        int k=0;
        for(int i=columnTitle.length()-1;i>=0;i--){
            ans+=Math.pow(26,k)*(columnTitle.charAt(i)-64);
            k++;
        }
        return ans;
    }
}