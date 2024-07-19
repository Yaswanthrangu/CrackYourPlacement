import java.util.*;

public class BFS {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList <Integer> ans = new ArrayList<>();
        Queue <Integer> q = new LinkedList<>();
        q.add(0);
        int vis[] = new int[V];
        vis[0] = 1;
        while(!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            for(int ele : adj.get(node)) {
                if(vis[ele] == 0) {
                    q.add(ele);
                    vis[ele] = 1;
                }
            }
        }
        return ans;
    }
}