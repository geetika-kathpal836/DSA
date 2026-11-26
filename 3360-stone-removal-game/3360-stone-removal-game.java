class Solution {
    public boolean canAliceWin(int n) {
        int start=10;
        boolean alice=false;
        boolean bob=false;
        int chancenumber=1;
        while(n>=start && start>=0){
            n-=start;
            if(chancenumber%2!=0){
                alice=true;
                bob=false;
            }else{
                bob=true;
                alice=false;
            }
            start-=1;
            chancenumber++;
        }
        return alice;
    }
}