class Solution {
    public int[] findOrder(int numCourses, int[][] pre) {
        int[] order=new int[numCourses];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<Integer>());
        }
        int[] indegree=new int[numCourses];
        for(int i=0;i<pre.length;i++){
            int u=pre[i][0];
            int v=pre[i][1];
            adj.get(v).add(u);
            indegree[u]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        int j=0;
        int cnt=0;
        while(!q.isEmpty()){
            int node=q.poll();
            order[j++]=node;
            cnt++;
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.offer(it);
                }
            }
        }
        int[] emptyarr=new int[0];
        return (cnt==numCourses)?order:emptyarr;
    }
}