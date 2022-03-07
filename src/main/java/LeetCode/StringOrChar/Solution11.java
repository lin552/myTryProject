package LeetCode.StringOrChar;

/**
 * 赎金信
 */
public class Solution11 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        //因为每个字母只出现一次，创建长度26的数组
        int[] cnt = new int[26];
        //遍历字符串，每有一个则在数组中++ 也就是赋值1
        for (char c : magazine.toCharArray()
        ) {
            cnt[c - 'a']++;
        }
        //遍历字符串，每出现一次就-- 出现了尚未出现的就会小于0
        for (char c : ransomNote.toCharArray()
        ) {
            cnt[c - 'a']--;
            if (cnt[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
