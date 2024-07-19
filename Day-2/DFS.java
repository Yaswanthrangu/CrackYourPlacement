import java.util.*;

public class DFS {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList <Integer> ans = new ArrayList<>();
        int vis[] = new int[V];
        dfs(V, adj, 0, vis, ans);
        return ans;
    }
    public static void dfs(int V, ArrayList<ArrayList<Integer>> adj, int i, int vis[], ArrayList <Integer> ans) {
        vis[i] = 1;
        ans.add(i);
        for(int ele : adj.get(i)) {
            if(vis[ele] == 0) {
                dfs(V, adj, ele, vis, ans);
            }
        }
    }
}