package study.dp;

/**
 * @author yangxian007
 * @date 2023/10/3
 */
public class CoinChange {

    public static  int minCount = Integer.MAX_VALUE;

    /**
     * @param i 当前硬币的面值
     * @param j 当前硬币总数
     * @param k 当前硬币总价值
     * @param sumMoney 目标金额
     */
    public static void findMinCount(int i, int j, int k, int sumMoney) {
        if (k > sumMoney) {
            return;
        }
        if (k == sumMoney) {
            if (j < minCount) {
                minCount = j;
            }
            return;
        }
        findMinCount(1, j+1, k+1, sumMoney);
        findMinCount(3, j+1, k+3, sumMoney);
        findMinCount(5, j+1, k+5, sumMoney);
    }

    public static int findMinCount(int sumMoney) {
        if (sumMoney < 0) {
            return Integer.MAX_VALUE;
        }
        if (sumMoney == 0) {
            return 0;
        }
        if (sumMoney == 1) {
            return 1;
        }
        if (sumMoney == 3) {
            return 1;
        }
        if (sumMoney == 5) {
            return 1;
        }
        int minCount_1 = findMinCount(sumMoney-1);
        int minCount_3 = findMinCount(sumMoney-3);
        int minCount_5 = findMinCount(sumMoney-5);
        return 1 + minCount_1 < minCount_3 ? ( minCount_1 < minCount_5 ?  minCount_1 : minCount_5) : (minCount_3 < minCount_5 ? minCount_3 : minCount_5);
    }

    public static void main(String[] args) {
//        findMinCount(0, 0, 0, 7);
//        System.out.println(minCount);

        System.out.println(findMinCount(3));

    }

}
