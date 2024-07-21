import java.util.*;

public class ThreeSum {

    // Brute Force

    public List<List<Integer>> brute(int[] nums) {
        Set<List<Integer>> temp = new HashSet<>();
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                for(int k = j+1; k < n; k++) {
                    if(nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> tempList = Arrays.asList(nums[i], nums[j], nums[k]);
                        tempList.sort(null);
                        temp.add(tempList);
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(temp);
        return ans;
    }

    // Better Approach

    public List<List<Integer>> better(int[] nums) {
        Set<List<Integer>> temp = new HashSet<>();
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            HashSet <Integer> st = new HashSet<>();
            for(int j = i+1; j < n; j++) {
                int remaining = -(nums[j] + nums[i]);
                if(st.contains(remaining)) {
                    List<Integer> tempList = Arrays.asList(nums[i], nums[j], remaining);
                    tempList.sort(null);
                    temp.add(tempList);
                }
                st.add(nums[j]);
            }
        }
        List<List<Integer>> ans = new ArrayList<>(temp);
        return ans;
    }

    // Optimized Approach

    public List<List<Integer>> optimal(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i + 1;
            int k = n - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < 0) {
                    j++;
                }
                else if(sum > 0) {
                    k--;
                }
                else {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }
        return ans;
    }
}