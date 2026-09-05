class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int maxsum=0;
        for(int i=0;i<k;i++){
            maxsum+=cardPoints[i];
        }
        int right=cardPoints.length-1;
        int sum=maxsum;
        for(int i=k-1;i>=0;i--){
            sum=sum-cardPoints[i]+cardPoints[right];
            right--;
            maxsum=Math.max(maxsum,sum);
        }
        return maxsum;
    }
}