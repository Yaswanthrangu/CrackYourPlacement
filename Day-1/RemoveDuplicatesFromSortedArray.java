import java.util.*;

public class RemoveDuplicatesFromSortedArray {
    
    // Brute Force

    public int better(int[] nums) {
        int n = nums.length;
        // Using ArrayList to modify the array from starting places
        // Why not Set ? : Set doesn't contain get method to traverse and manipulate elements in array from start
        ArrayList <Integer> ar = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(!(ar.contains(nums[i]))) {
                ar.add(nums[i]);
            }
        }
        int k = ar.size();
        for(int i = 0; i < k; i++) {
            nums[i] = ar.get(i);
        }
        return k;
    }

    // Optimal

    public int optimal(int[] nums) {
        int n = nums.length;
        int j = 0;
        for(int i = 1; i < n; i++) {
            if(nums[i-1] != nums[i]) {
                nums[j+1] = nums[i];
                j++;
            }
        }
        return (j+1);
    }
}