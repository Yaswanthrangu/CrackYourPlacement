import java.util.*;

public class ClimbingStairs {
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return helper(n, dp);
    }
    public static int helper(int n, int dp[]) {
        if(n == 0 || n == 1) {
            return 1;
        }
        if(dp[n] != -1) {
            return dp[n];
        }
        int oneForward = helper(n - 1, dp);
        int twoForward = helper(n - 2, dp);
        return dp[n] = oneForward + twoForward;
    }
}