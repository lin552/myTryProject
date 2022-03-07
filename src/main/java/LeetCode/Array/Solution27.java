package LeetCode.Array;

import java.util.*;

/**
 * 540
 * 有序数组中的单一元素
 */
public class Solution27 {
    public int singleNonDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) >= 2) {
                map.remove(nums[i]);
            }
        }
        if (!map.isEmpty()) {
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Integer key = iterator.next().getKey();
                return key;
            }
        }
        return 0;
    }

    /**
     * 全数组的二分查找
     * @param nums
     * @return
     */
    public int singleNonDuplicate1(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            //先找中间位
            int mid = (high - low) / 2 + low;
            //通过中间位的奇偶数来
            if (nums[mid] == nums[mid ^ 1]) {
                //如果mid是偶数，比较nums[mid] 和 nums[mid+1]是否相等
                low = mid + 1;
            } else {
                //如果mid是奇数，比较nums[mid-1]和 nums[mid]是否相等
                high = mid;
            }
        }
        return nums[low];
    }

    /**
     * 偶数下边的二分查找
     * @param nums
     * @return
     */
    public int singleNonDuplicate2(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            // 当mid 是偶数时，mid & 1 = 0
            // 当mid 是奇数时，mid & 1 = 1
            mid -= mid & 1;
            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
}
