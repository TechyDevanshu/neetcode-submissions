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
    public ListNode reverseKGroup(ListNode head, int k) {
            //  [1,2,3,4,5,6],K=3;

            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode prevGroupEnd = dummy;

            while (true) {
                ListNode kth = getKthNode(prevGroupEnd, k);
                if(kth==null){
                    break;
                }

                ListNode nextGroupStart = kth.next;

                ListNode prev = nextGroupStart;
                ListNode curr = prevGroupEnd.next;

                while (curr != nextGroupStart) {
                    ListNode temp = curr.next;
                    curr.next = prev;

                    prev = curr;
                    curr = temp;
                }

                ListNode temp = prevGroupEnd.next;
                prevGroupEnd.next = kth;
                prevGroupEnd = temp;
            }
            return dummy.next;
        }

        public ListNode getKthNode(ListNode curr, int k) {
            while (curr != null && k > 0) {
                curr = curr.next;
                k--;
            }
            return curr;
        }
}
