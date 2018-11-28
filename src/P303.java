import java.util.Arrays;

public class P303
{
    public static void main(String[] args) {
        int[] nums = new int[] {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }
}

class NumArray {

    private final int N = 50000;
    private int[] c = new int[N];

    public NumArray(int[] nums) {
        Arrays.fill(c, 0);
        for (int i = 0; i < nums.length; ++i)
            add(i + 1, nums[i]);
    }

    public int sumRange(int i, int j) {
        return sum(j + 1) - sum(i);
    }

    private int lowbit(int i) { return i & (-i); }

    private void add(int x, int a) {
        for (int i = x; i < N; i += lowbit(i)) {
            c[i] += a;
        }
    }

    private int sum(int x) {
        int res = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            res += c[i];
        }
        return res;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */