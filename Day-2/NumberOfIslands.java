import java.util.*;

class Pair {
    int first;
    int second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '1' && vis[i][j] == 0) {
                    // Try to pass i, j, m and n
                    bfs(grid, vis, i, j, n, m);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void bfs(char grid[][], int vis[][], int strow, int stcol, int n, int m) {
        Queue <Pair> q = new LinkedList<>();
        q.add(new Pair(strow, stcol));
        vis[strow][stcol] = 1;
        int delrow[] = {-1, 0, 1, 0};
        int delcol[] = {0, 1, 0, -1};
        while(!q.isEmpty()) {
            Pair res = q.poll();
            int row = res.first;
            int col = res.second;
            for(int i = 0; i < 4; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0) {
                    q.add(new Pair(nrow, ncol));
                    vis[nrow][ncol] = 1;
                }
            }
        }
    }
}