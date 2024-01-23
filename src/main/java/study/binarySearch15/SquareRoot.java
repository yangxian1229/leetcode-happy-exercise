package study.binarySearch15;

import java.math.BigDecimal;

/**
 * @author yangxian007
 * @date 2023/7/16
 */
public class SquareRoot {
    private static double sqr(double n, double precision) {
        if (n < 0) {
            throw new IllegalArgumentException("n < 0");
        }
        double low = 0;
        double high = n;
        double mid;
        while (true) {
            mid = (low + high) / 2;
            if (Math.abs(mid * mid - n) < precision) {
                return mid;
            }
            if (mid * mid > n) {
                high = mid;
            } else {
                low = mid;
            }
        }
    }
    public static void main(String[] args) {
        double precision = 1e-6;
        System.out.println(sqr(0, precision));
    }
}
