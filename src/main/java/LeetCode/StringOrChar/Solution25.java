package LeetCode.StringOrChar;

/**
 * 最长的美好子字符串
 */
public class Solution25 {

    public String longestNiceSubstring(String s) {
        //字符长度
        int n = s.length();
        int maxPos = 0;
        int maxLen = 0;
        for (int i = 0; i < n; ++i) {
            int lower = 0;
            int upper = 0;
            for (int j = 0; j < n; ++j) {
                if (Character.isLowerCase(s.charAt(j))) {
                    lower |= 1 << (s.charAt(j) - 'a');
                } else {
                    upper |= 1 << (s.charAt(j) - 'A');
                }
                if (lower == upper && j - i + 1 > maxLen) {
                    maxPos = i;
                    maxLen = j - i + 1;
                }
                }
            }
        return s.substring(maxPos, maxPos + maxLen);
    }
}
