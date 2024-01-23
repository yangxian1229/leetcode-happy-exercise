package study.sort;

/**
 * @author yangxian007
 * @date 2023/8/22
 */
public class MergeSort {
    public static void mergeSort(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = (p + r) / 2;
        mergeSort(a, p, q);
        mergeSort(a, q + 1, r);
        merge(a, p, q, r);
    }

    public static void merge(int[] a, int p, int q, int r) {
        int i = p, j = q + 1, k = 0;
        int[] temp = new int[r - p + 1];
        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        // 判断哪个数组还有剩余
        int start = i, end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        while (start <= end) {
            temp[k++] = a[start++];
        }

        for (int index = 0; index < r - p + 1; index++) {
            a[p + index] = temp[index];
        }
    }

    public static void main(String[] args) {
        int[] a = {123, 45, 6, 7, 21, 9, 78, 48, 1, 3, 4, 5, 6, 8, 22, 12, 78, 100};
        mergeSort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
        System.out.println();
    }
}
