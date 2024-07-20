import java.util.*;

public class FindAllDuplicatesInArray {

    // Brute Force

    public List<Integer> brute(int[] nums) {
        int n = nums.length;
        ArrayList <Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int ele = nums[i];
            int cnt = 0;
            for(int j = 0; j < n; j++) {
                if(ele == nums[j]) {
                    cnt++;
                }
                if(cnt == 2) {
                    if(!ans.contains(ele)) {
                        ans.add(ele);
                    }
                }
            }
        }
        return ans;
    }

    // Better Approach

    public List<Integer> better(int[] nums) {
        int n = nums.length;
        ArrayList <Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 1; i < n; i++) {
            if(nums[i] == nums[i-1]) {
                if(!ans.contains(nums[i])) {
                    ans.add(nums[i]);
                }
            }
        }
        return ans;
    }

    // Optimized Approach

    public List<Integer> optimal(int[] nums) {
        int n = nums.length;
        ArrayList <Integer> ans = new ArrayList<>();
        HashMap <Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < n; i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0)+1);
        }
        for(int ele : mp.keySet()) {
            if(mp.get(ele) == 2) {
                ans.add(ele);
            }
        }
        return ans;
    }
}