import java.util.*;

class Pair {
    int node, wt;

    Pair(int node, int wt) {
        this.node = node;
        this.wt = wt;
    }
}

class Solution {
    public ArrayList<Integer> shortestPath(int V, int[][] edges, int src, int dest) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i <= V; i++)
            adj.add(new ArrayList<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(new Pair(e[1], e[2]));
            adj.get(e[1]).add(new Pair(e[0], e[2]));
        }

        // Sort neighbours so that we always try smaller vertices first
        for (int i = 1; i <= V; i++) {
            Collections.sort(adj.get(i), (a, b) -> a.node - b.node);
        }

        long[] dist = new long[V + 1];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);

        dist[src] = 0;
        pq.offer(new Pair(src, 0));

        while (!pq.isEmpty()) {

            Pair cur = pq.poll();

            if (cur.wt != dist[cur.node])
                continue;

            for (Pair nxt : adj.get(cur.node)) {

                long newDist = dist[cur.node] + nxt.wt;

                if (newDist < dist[nxt.node]) {
                    dist[nxt.node] = newDist;
                    pq.offer(new Pair(nxt.node, (int) newDist));
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        if (dist[dest] == Long.MAX_VALUE) {
            ans.add(-1);
            return ans;
        }

        // Build reverse shortest-path graph
        ArrayList<ArrayList<Integer>> rev = new ArrayList<>();

        for (int i = 0; i <= V; i++)
            rev.add(new ArrayList<>());

        for (int[] e : edges) {

            int u = e[0];
            int v = e[1];
            int w = e[2];

            if (dist[u] + w == dist[v])
                rev.get(v).add(u);

            if (dist[v] + w == dist[u])
                rev.get(u).add(v);
        }

        // Find all nodes from which destination is reachable
        boolean[] good = new boolean[V + 1];

        Queue<Integer> q = new LinkedList<>();
        q.offer(dest);
        good[dest] = true;

        while (!q.isEmpty()) {

            int node = q.poll();

            for (int prev : rev.get(node)) {
                if (!good[prev]) {
                    good[prev] = true;
                    q.offer(prev);
                }
            }
        }

        int curr = src;
        ans.add(curr);

        while (curr != dest) {

            for (Pair nxt : adj.get(curr)) {

                if (!good[nxt.node])
                    continue;

                if (dist[curr] + nxt.wt == dist[nxt.node]) {
                    curr = nxt.node;
                    ans.add(curr);
                    break;
                }
            }
        }

        return ans;
    }
}