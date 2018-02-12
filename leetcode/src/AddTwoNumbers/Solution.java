package AddTwoNumbers;
/*
Add Two Numbers
Description
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
Tags: Linked List, Math
*/
public class Solution {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    /*
    * 模拟运算过程，每次相加之后将内容存储，然后除10降位之后重新进入下轮计算
    * 最后要针对降位之后的最后一次结果，是否大于10，如果大于10则要进行最后一位的添加
    * */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode node = new ListNode(0);
        ListNode n1 = l1, n2 = l2, t = node;
        int sum = 0;
        while (n1 != null || n2 != null){
            sum /= 10;
            if (n1 != null){
                sum += n1.val;
                n1 = n1.next;
            }
            if (n2 != null){
                sum += n2.val;
                n2 = n2.next;
            }
            t.next = new ListNode(sum % 10);
            t = t.next;
        }
        if (sum/10 != 0){
            t.next = new ListNode(1);
        }
        return node.next;
    }



}
