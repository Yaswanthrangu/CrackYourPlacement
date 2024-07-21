public class MajorityElement {

    // Brute Force

    public int brute(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        int ele = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            if(cnt == 0) {
                ele = nums[i];
                cnt++;
            }
            else if(nums[i] == ele) {
                cnt++;
            }
            else {
                cnt--;
            }
        }
        int res = ele;
        int count = 0;
        for(int element : nums) {
            if(element == res) {
                count++;
            }
        }
        if(count > (n / 2)) {
            return res;
        }
        return -1;
    }
}