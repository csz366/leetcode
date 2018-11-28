public class P198
{
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 1};
        Solution solution = new Solution();
        System.out.println(solution.rob(nums));
    }
}

class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] d = new int[n];
        d[0] = nums[0];
        if (n == 1) return d[0];
        d[1] = Math.max(nums[0], nums[1]);
        if (n == 2) return d[1];
        d[2] = Math.max(nums[0] + nums[2], nums[1]);
        if (n == 3) return d[2];
        int ans = d[2];
        for (int i = 3; i < n; ++i)
        {
            d[i] = Math.max(d[i - 2], d[i - 3]) + nums[i];
            ans = Math.max(d[i], ans);
        }
        return ans;
    }
}