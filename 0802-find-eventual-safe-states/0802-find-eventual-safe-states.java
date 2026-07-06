class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int[] indegree=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<graph.length;i++){
            for(int it:graph[i]){
                adj.get(it).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        List<Integer> ans=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int node=q.poll();
            ans.add(node);
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.offer(it);
                }
            }
            
        }
        Collections.sort(ans);
        return ans;
    }
}