package leetcode;

import java.util.*;

/**
 * 回溯算法 + 剪枝
 */
public class M39_CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(candidates,0, target, combine, ret);
        return ret;
    }

    private static void dfs(int[] candidates, int idx, int target, List<Integer> combine, List<List<Integer>> ret) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ret.add(new ArrayList<Integer>(combine));
            return;
        }
        // 直接跳过当前数
        dfs(candidates, idx+1, target, combine, ret);
        // 选择当前数
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, idx, target-candidates[idx], combine, ret);
            combine.remove(combine.size()-1);
        }
    }



    public static void main(String[] args) {
       int[] candidates = new int[]{2,3,5};
        List<List<Integer>> ret = M39_CombinationSum.combinationSum(candidates, 7);

        for(List<Integer> nowRet : ret) {
            System.out.print("[");
            for(Integer nowNum : nowRet) {
                System.out.print(nowNum + ", ");
            }
            System.out.println("]");
        }
    }

    public static class M29_Divide {
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
}
