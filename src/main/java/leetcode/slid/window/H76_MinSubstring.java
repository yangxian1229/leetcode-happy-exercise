package leetcode.slid.window;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangxian007
 * @date 2024/1/10
 */
public class H76_MinSubstring {
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        // key: 字符串 value: 字符串出现的次数
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        boolean exist = false;
        String minSubstring = s;
        // i 左指针 j 右指针
        int i = 0, j = 0;
        while (i <= j && j < s.length()) {
            sMap.put(s.charAt(j), sMap.getOrDefault(s.charAt(j), 0) + 1);
            while (i <= j && check(tMap, sMap)) {
                exist = true;

                if (j - i + 1 == t.length()) {
                    return s.substring(i, j + 1);
                }
                if (j - i + 1 < minSubstring.length()) {
                    minSubstring = s.substring(i, j + 1);
                }
                sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) - 1);
                i++;
            }
            j++;
        }
        if (exist) {
            return minSubstring;
        }
        return "";
    }

    public static boolean check(Map<Character, Integer> tMap, Map<Character, Integer> sMap) {
        if (sMap.size() == 0) {
            return false;
        }
        for (Map.Entry<Character, Integer> tEntry : tMap.entrySet()) {
            Integer sEntryValue = sMap.get(tEntry.getKey());
            if (null == sEntryValue || sEntryValue < tEntry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String result = minWindow(s, t);
        System.out.println(result);
    }
}
