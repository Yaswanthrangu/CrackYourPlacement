import java.util.*;

public class FindDuplicates {

    // Brute Force

    public int brute(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int cnt = 0;
            int ele = nums[i];
            for(int j = 0; j < n; j++) {
                if(ele == nums[j]) {
                    cnt++;
                }
            }
            // cnt == 2 will be a wrong case as duplicate elements cnt will be just greater than 1
            if(cnt > 1) {
                return ele;
            }
        }
        return -1;
    }

    // Better Approach

    public int better(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 1; i < n; i++) {
            if(nums[i-1] == nums[i]) {
                return nums[i];
            }
        }
        return -1;
    }

    // Optimized Approach

    public int optimal(int[] nums) {
        int n = nums.length;
        HashMap <Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < n; i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0)+1);
        }
        for(int key : mp.keySet()) {
            if(mp.get(key) > 1) {
                return key;
            }
        }
        return -1;
    }
}