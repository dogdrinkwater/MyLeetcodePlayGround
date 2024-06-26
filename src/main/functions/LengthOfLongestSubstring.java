package main.functions;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
     *
     * 示例 1:
     *
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * 提示：
     *
     * 0 <= s.length <= 5 * 104
     * s 由英文字母、数字、符号和空格组成
     * Related Topics
     * 哈希表
     * 字符串
     * 滑动窗口
     * */
    public static void main(String[] args) {
        String s = " s";
        execute(s);
    }

    private static int execute(String s) {
        Map<Character, Integer> hashTable = new HashMap<>();
        int point = -1;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (hashTable.containsKey(s.charAt(i))) {
                point = Math.max(point, hashTable.get(s.charAt(i)));
            }
            hashTable.put(s.charAt(i), i);
            maxLength = Math.max(maxLength, i - point);
        }
        return maxLength;
    }
}
