package LeetCode.Array;

import java.util.Arrays;

/**
 * 合并两个有序数组
 */
public class Solution3 {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 0, 0, 0};
        int b = 3;
        int[] c = new int[]{2, 5, 6};
        int d = 3;
        merge2(a, b, c, d);
    }

    /**
     * 先合并再排序
     * for循环赋值
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i != n; i++) {
            nums1[m + i] = nums2[2];
        }
        Arrays.sort(nums1);
    }

    /**
     * 先合并再排序
     * 通过数组拷贝方式
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * 双指针
     * 边比大小边移动到新数组 sorted中
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
            for (int i = 0; i != m + n; i++) {
                nums1[i] = sorted[i];
            }
        }
        for (int i = 0; i < nums1.length - 1; i++) {
            System.out.println(nums1[i]);
        }
    }

    /***
     * 逆向双指针
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge3(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }

    }
}
