class Solution {
    public int numberOfSubstrings(String s) {
        int cnt=0;
        int[] lastseen=new int[3];
        Arrays.fill(lastseen,-1);
        for(int i=0;i<s.length();i++){
            lastseen[s.charAt(i)-'a']=i;
            int min=lastseen[0];
            if(min>lastseen[1] || min>lastseen[2]){
                if(lastseen[1]>lastseen[2]){
                    min=lastseen[2];
                }else{
                    min=lastseen[1];
                }
            }
            cnt+=1+min;
        }
        return cnt;
    }
}