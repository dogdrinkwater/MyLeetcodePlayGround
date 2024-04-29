package main.functions;

public class ZConvert {
    public static void main(String[] args) {
        convert("PAYPALISHIRING", 4);
    }

    public static String convert(String s, int numRows) {
        int len = s.length();
        if (len <= numRows) {
            return s;
        }

        char[] chars = s.toCharArray();
        int i = numRows;
        int blockLen = numRows + numRows / 2;
        boolean match = len % blockLen == 0;
        int j = (len / blockLen) * (numRows / 2 + 1) + (match ? 0 : 1);
        String[][] dp = new String[i][j];

        int k = 0;
        int num = 0;
        int x = numRows - 2;
        int y = 0;
        for (int l = 0; l < j; l++) {
            for (int m = 0; m < i; m++) {
                if ( k >= len) {
                    break;
                }
                if (l % (numRows - 1) == 0) {
                    dp[m][l] = chars[k++] + "";
                } else {
                    if (0 < m && m <= numRows / 2 && num == ((l * numRows) + x)) {
                        dp[m][l] = chars[k++] + "";
                        x--;
                        y++;
                        if (blockLen - numRows - y == 0) {
                            x = numRows - 2;
                            y = 0;
                        }
                    } else {
                        dp[m][l] = "";
                    }
                }
                num ++;
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int m = 0; m < i; m++) {
            for (int l = 0; l < j; l++) {
                if (null != dp[m][l]) {
                    sb.append(dp[m][l]);
                }
            }
        }
        return sb.toString();
    }
}

/**
 *
 * class Solution {
 *     public String convert(String s, int numRows) {
 * int len = s.length();
 *         if (len <= numRows) {
 *             return s;
 *         }
 *
 *         char[] chars = s.toCharArray();
 *         int i = numRows;
 *         int blockLen = numRows + numRows / 2;
 *         boolean match = len % blockLen == 0;
 *         int j = (len / blockLen) * (numRows / 2 + 1) + (match ? 0 : 1);
 *         String[][] dp = new String[i][j];
 *
 *         int k = 0;
 *         int num = 0;
 *         for (int l = 0; l < j; l++) {
 *             int x = numRows - 2;
 *             for (int m = 0; m < i; m++) {
 *                 if ( k >= len) {
 *                     break;
 *                 }
 *                 if (l % (numRows - 1) == 0) {
 *                     dp[m][l] = chars[k++] + "";
 *                 } else {
 *                     if (0 < m && m <= numRows / 2 && num == ((l * numRows) + x)) {
 *                         dp[m][l] = chars[k++] + "";
 *                         x--;
 *                     } else {
 *                         dp[m][l] = "";
 *                     }
 *                 }
 *                 num ++;
 *             }
 *         }
 *
 *
 *         StringBuilder sb = new StringBuilder();
 *         for (int m = 0; m < i; m++) {
 *             for (int l = 0; l < j; l++) {
 *                 if (null != dp[m][l]) {
 *                     sb.append(dp[m][l]);
 *                 }
 *             }
 *         }
 *         return sb.toString();
 *     }
 * }
 * */
