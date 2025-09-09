/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(), result = sentinel;
        int sum = 0;
        while (l1 != null && l2 != null) {
            sum += l1.val + l2.val;
            ListNode p = new ListNode(sum % 10);
            sum /= 10;

            l1 = l1.next;
            l2 = l2.next;
            result.next = p;
            result = p;

        }

        while (l1 != null) {
            sum += l1.val;
            ListNode p = new ListNode(sum % 10);
            result.next = p;
            result = p;
            l1 = l1.next;
            sum /= 10;
        }

        while (l2 != null) {
            sum += l2.val;
            ListNode p = new ListNode(sum % 10);
            sum /= 10;
            result.next = p;
            result = p;
            l2 = l2.next;
        }

        if (sum > 0) result.next = new ListNode(sum);

        return sentinel.next;
    }
}