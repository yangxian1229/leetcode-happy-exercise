package study.binarySearch15;

/**
 * leetcode 153题
 * @author yangxian007
 * @date 2023/7/18
 */
public class FindMin153 {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int low = 0;
        int high = n-1;
        int mid = 0;

        while (low <= high) {
            mid = (low+high)/2;
            if (mid == 0 && nums[mid+1] > nums[mid]) {
                return nums[mid];
            }
            if (mid == n-1 && nums[mid-1] > nums[mid]) {
                return nums[mid];
            }
            if (nums[mid-1] > nums[mid] && nums[mid+1] > nums[mid]) {
                return nums[mid];
            }
            if (nums[high] < nums[low]) {
                if (nums[high] < nums[mid]) {
                    low = mid + 1;
                }else {
                    high = mid -1;
                }
            } else {
                high = mid-1;
            }
        }
        return -1;
    }
}
