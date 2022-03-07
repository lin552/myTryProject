package LeetCode.Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 求是否有相同元素
 */
public class Solution {



    public static void main(String[] args) {

        int[] list = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        boolean b = containsDuplicate1(list);
        System.out.println(b);
    }

    /**
     * 排序
     * 排序完判断相邻是否有相等
     *
     * 时间复杂度：O(NlogN)，其中 NN 为数组的长度。需要对数组进行排序。
     * 空间复杂度：O(logN)，其中 NN 为数组的长度。注意我们在这里应当考虑递归调用栈的深度。
     *
     * @param nums
     * @return
     */
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }


    /**
     * 哈希表
     * 添加到哈希表内自动去重
     *
     * 时间复杂度：O(N)，其中 NN 为数组的长度。
     * 空间复杂度：O(N)，其中 NN 为数组的长度。
     * @param nums
     * @return
     */
    public static boolean containsDuplicate1(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int x : nums) {
            if (!set.add(x)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 哈希
     * 用Stream
     * @param nums
     * @return
     */
    public static boolean containsDuplicate2(int[] nums) {
        return IntStream.of(nums).distinct().count() != nums.length;
    }
}
