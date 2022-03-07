package LeetCode.Array;

import java.util.*;

/**
 * 两个数组的交集 II
 */
public class Solution4 {

    /**
     * 哈希map先遍历短数组
     * 记录元素出现次数
     * 遍历长数组时，将重复元素整理出来
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        //寻找最短的数组
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //遍历短数组
        for (int num : nums1
        ) {
            //记录每个元素出现的次数在map中
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num :
                nums2) {
            int count = map.getOrDefault(num, 0);
            //遍历长数组
            if (count > 0) {
                //每找到一个合集元素就放到新数组中并count--
                intersection[index++] = num;
                count--;

                //如果count还未到0就把重新对map中的count赋值
                //否则就直接从map中移除
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        //拷贝一次将非0移除
        return Arrays.copyOfRange(intersection, 0, index);
    }

    /**
     * 对两个数组进行排序
     * 通过双指针对两个数组进行比较
     * 如果相等就同时移动指针，同时取出元素存新数组中
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect1(int[] nums1, int[] nums2) {
        //先对两个数组进行排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        //申请一个较小数组长度的新数组 （因为合集最大不可能超过短数组）
        int[] intersection = new int[Math.min(length1, length2)];
        int index1 = 0, index2 = 0, index = 0;
        //整两个指针，如果没遍历完就一直循环，但凡有个遍历完就停止，把短的遍历完就行
        while (index1 < length1 && index2 < length2) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                //如果相等就把相等的元素放到新数组里
                intersection[index] = nums1[index1];
                //两个数组的指针分别往前
                index1++;
                index2++;
                index++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

}
