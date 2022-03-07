package LeetCode.StringOrChar;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 字符串中的第一个唯一字符
 */
public class Solution10 {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }

    /**
     * Hash记录出现的次数
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {
        int len = s.length();
        //记录每个char出现的频率
        Map<Character, Integer> frequency = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        //通过遍历顺序保证前后
        //如果个数只出现一次则输出位置
        for (int i = 0; i < len; i++) {
            if (frequency.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 使用Hash表存储索引
     * @param s
     * @return
     */
    public static int firstUniqChar1(String s) {
        Map<Character, Integer> position = new HashMap<Character, Integer>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            //如果已存在则把索引存-1
            if (position.containsKey(ch)) {
                position.put(ch, -1);
            } else {
                position.put(ch, i);
            }
        }
        int first = n;
        //遍历map找最小的索引
        for (Map.Entry<Character, Integer> entry : position.entrySet()
        ) {
            int pos = entry.getValue();
            if (pos != -1 && pos < first) {
                first = pos;
            }
        }
        //如果没有找到那就是没有
        if (first == n) {
            first = -1;
        }
        return first;
    }

    /**
     * 队列
     * @param s
     * @return
     */
    public int firstUniqChar2(String s) {
        Map<Character, Integer> position = new HashMap<>();
        //创建一个链表
        Queue<Pair> queue = new LinkedList<Pair>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (!position.containsKey(ch)) {
                position.put(ch, i);
                queue.offer(new Pair(ch, i));
            } else {
                position.put(ch, -1);
                while (!queue.isEmpty() && position.get(queue.peek().ch) == -1) {
                    queue.poll();
                }
            }
        }
        return queue.isEmpty() ? -1 : queue.poll().pos;
    }

     class Pair{
        char ch;
        int pos;

        public Pair(char ch, int pos) {
            this.ch = ch;
            this.pos = pos;
        }
    }
}
