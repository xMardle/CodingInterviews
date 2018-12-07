package com.matao.Q15;

import com.matao.common.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * <p>
 * Author: matao
 */
public class KthNodeFromEnd {

    public static ListNode findKthFromEnd(ListNode<Integer> list, int k) {
        if (list == null || k == 0) {
            return null;
        }
        ListNode<Integer> p = list, q = list;
        while (k > 1) {
            q = q.next;
            if (q == null) {    // k大于结点总数
                return null;
            }
            k--;
        }

        while (q.next != null) {
            p = p.next;
            q = q.next;
        }
        return p;
    }

    public static void main(String[] args) {
        ListNode<Integer> node1 = new ListNode<>(1);
        ListNode<Integer> node2 = new ListNode<>(2);
        ListNode<Integer> node3 = new ListNode<>(3);
        node1.next = node2;
        node2.next = node3;

        System.out.println(findKthFromEnd(node1, 1).val);
        System.out.println(findKthFromEnd(node1, 2).val);
        System.out.println(findKthFromEnd(node1, 3).val);
        System.out.println(findKthFromEnd(node1, 4));
    }
}