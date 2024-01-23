package study.dp;

/**
 * 最长递增子序列长度
 *
 * @author yangxian007
 * @date 2023/10/4
 */
public class LongIncreasingSubsequence {

    public static int findLIS(int[] nums) {
        int[] values = new int[nums.length];
        int max_all = 0;
        for (int i = 0; i < nums.length; i++) {
            int max_i = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j] && values[j] + 1 > max_i) {
                    max_i = values[j] + 1;
                }
            }
            values[i] = max_i;
            if (values[i] > max_all) {
                max_all = values[i];
            }
        }
        return max_all;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,3,6,7,9,4,10,5,6};
        System.out.println(findLIS(a));
    }
}
