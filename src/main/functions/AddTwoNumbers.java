package main.functions;

import main.common.ListNode;

public class AddTwoNumbers {
    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     *
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例 1：
     *
     *
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     * 示例 2：
     *
     * 输入：l1 = [0], l2 = [0]
     * 输出：[0]
     * 示例 3：
     *
     * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * 输出：[8,9,9,9,0,0,0,1]
     * 提示：
     *
     * 每个链表中的节点数在范围 [1, 100] 内
     * 0 <= Node.val <= 9
     * 题目数据保证列表表示的数字不含前导零
     * Related Topics
     * 递归
     * 链表
     * 数学
     */
    public static void main(String[] args) {
        execute(new ListNode(2, new ListNode(4, new ListNode(3))), new ListNode(5, new ListNode(6, new ListNode(4))));
    }

    public static ListNode execute(ListNode l1, ListNode l2) {
        ListNode n1 = null, n2 = null; // n1 表示链表头 n2 表示链表尾
        int res = 0; // 存储每次两个数字加完之后 大于10的部分
        while (l1 != null || l2 != null) {
            res += (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            if (n1 == null) { // 说明链表还没有内容
                n1 = n2 = new ListNode(res % 10);
            } else { // 链表已经有内容 给 尾部添加数据就可以
                n2.next = new ListNode(res % 10);
                n2 = n2.next; // 链表尾部移动
            }
            res = res / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if (res > 0) {
            n2.next = new ListNode(res);
        }

        return n1;
    }
}

