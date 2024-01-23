package test;

/**
 * 测试快排
 * @author yangxian007
 * @date 2023/7/3
 */
public class Copilot {
    // 写一个快排
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = partition(arr, left, right);
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot, right);
    }

    static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        while (left < right) {
            while (arr[right] > pivot) {
                right--;
            }

            while (arr[left] < pivot) {
                left++;
            }

            if (left < right) {
                swap(arr, left, right);
            }
        }

        return left;
    }

    static void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
