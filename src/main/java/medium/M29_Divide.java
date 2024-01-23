package medium;

import java.util.HashMap;
import java.util.Map;

public class M29_Divide {
    public static int divide(int dividend, int divisor) {
        boolean positiveFlag = true;
        if (dividend < 0 && divisor > 0 ) {
            dividend = -dividend;
            positiveFlag = false;
        } else if (dividend > 0 && divisor <0) {
            divisor = -divisor;
            positiveFlag = false;
        } else if (dividend < 0 && divisor < 0) {
            dividend = -dividend;
            divisor = -divisor;
        } else if (dividend == -2147483648) {
            dividend = 2147483647;
        } else if (divisor == -2147483648) {
            divisor = 2147483647;
        }

        if (dividend == 0 || dividend < divisor) {
            return 0;
        }

        // 当前总和，当前结果
        int sum = divisor, result = 1,
                // 当前指针指向的key
                nowKey = 1;
        // 指针走向，true向前走，false向后走
        boolean upflag = true;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(nowKey, divisor);
        while (true) {
            System.out.println("sum:"+sum+", result:"+result+", nowKey:"+nowKey);
            if (sum == dividend || (sum < dividend && (dividend - sum) < divisor)) {
                if (positiveFlag) {
                    return result;
                }
                return -result;
            }
            if (upflag) {
                // 如果sum能翻倍，则翻倍，不能就改变指针方向
                if (map.get(nowKey)+map.get(nowKey) < dividend) {
                    map.put(nowKey+nowKey, map.get(nowKey)+map.get(nowKey));
                    // nowKey翻倍
                    nowKey = nowKey+nowKey;
                    sum = map.get(nowKey);
                    result = nowKey;
                } else {
                    upflag = false;
                }
            }
            if (!upflag){
                nowKey = nowKey >> 1;
                // 如果现在指向的结果可以加入sum，则加入sum，否则指针继续往下走
                if (sum + map.get(nowKey) < dividend) {
                    sum = sum + map.get(nowKey);
                    result = result + nowKey;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(M29_Divide.divide(-2147483648, -1));
    }
}
