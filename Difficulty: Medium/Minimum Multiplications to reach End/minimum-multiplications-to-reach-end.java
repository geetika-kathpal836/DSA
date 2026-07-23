class Pair{
    int step;
    int node;
    Pair(int step, int node){
        this.step=step;
        this.node=node;
    }
}
class Solution {
    public int minSteps(int[] arr, int start, int end) {
        // code here
        int steps[]=new int[1000];
        for(int i=0;i<1000;i++){
            steps[i]=(int)(1e9);
        }
        steps[start]=0;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(0,start));
        while(!q.isEmpty()){
            Pair p=q.poll();
            int st=p.step;
            int nd=p.node;
            if(nd==end) return st;
            for(int i=0;i<arr.length;i++){
                int res=(arr[i]*nd)%1000;
                if(st+1<steps[res]){
                    steps[res]=st+1;
                    q.offer(new Pair(st+1,res));
                }
            }
        }
        return -1;
    }
}