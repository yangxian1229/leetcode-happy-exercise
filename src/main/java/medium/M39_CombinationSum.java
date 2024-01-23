package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
}
