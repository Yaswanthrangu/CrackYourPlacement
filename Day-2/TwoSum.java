import java.util.*;

public class TwoSum {

    // Brute Force

    public int[] brute (int[] nums, int target) {
        int n = nums.length;
        for(int i = 0; i < n - 1; i++) {
            for(int j = i+1; j < n; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {-1, -1};
    }

    // Optimized Approach

    public int[] optimal(int[] nums, int target) {
        int n = nums.length;
        HashMap <Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < n; i++) {
            mp.put(nums[i], i);
        }
        for(int i = 0; i < n; i++) {
            int now = nums[i];
            int req = target - now;
            if(mp.containsKey(req) && i != mp.get(req)) {
                return new int[] {i, mp.get(req)};
            }
        }
        return new int[] {-1, -1};
    }
}