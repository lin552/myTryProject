package LeetCode.LinkedList;

public class Solution15 {

    /**
     *
     * 移除链表元素
     */
    class Solution {
        /**
         * 递归
         * @param head
         * @param val
         * @return
         */
        public ListNode removeElements(ListNode head, int val) {
            //如果链表是空的，直接返回
            if (head == null) {
                return head;
            }
            head.next = removeElements(head.next, val);
            //判断head当前val是否和 head.next相等
            return head.val == val ? head.next : head;
        }

        /**
         * 迭代
         *
         * @param head
         * @param val
         * @return
         */
        public ListNode removeElements1(ListNode head, int val) {
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;
            ListNode temp = dummyHead;
            while (temp.next != null) {
                if (temp.next.val == val) {
                    temp.next = temp.next.next;
                } else {
                    temp = temp.next;
                }
            }
            return dummyHead.next;
        }
    }
}
