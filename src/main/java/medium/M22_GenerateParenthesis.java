package medium;

import java.util.ArrayList;
import java.util.List;

public class M22_GenerateParenthesis {

    /*********************  方法一：暴力法 ******************************************************、
     * 时间复杂度：O(2^{2n}*n),对于 2^{2n}个序列中的每一个，我们用于建立和验证该序列的复杂度为 O(n)。
     * 空间复杂度：O(n),除了答案数组之外，我们所需要的空间取决于递归栈的深度，每一层递归函数需要 O(1)的空间，最多递归 2n 层，因此空间复杂度为 O(n)
     */
    public static List<String> generateParenthesisMethod1(int n) {
        List<String> ret = new ArrayList<>();
        char[] nowRet = new char[2*n];
        nowRet[0] = '(';
        dfs(ret, nowRet, 1);
        return ret;
    }
    public static void dfs(List<String> ret, char[] nowRet, int pos) {
        if (pos == nowRet.length) {
            if (isOk(nowRet)) {
                ret.add(new String(nowRet));
            }
            return;
        }
        nowRet[pos] = '(';
        dfs(ret, nowRet, pos+1);
        nowRet[pos] = ')';
        dfs(ret, nowRet, pos+1);
    }

    public static boolean isOk(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') {
                ++balance;
            } else {
                --balance;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    public static void main(String[] args) {
        List<String>  ret = generateParenthesisMethod1(4);
        for(String nowRet:ret) {
            System.out.print(nowRet + ", ");
        }
    }
}
