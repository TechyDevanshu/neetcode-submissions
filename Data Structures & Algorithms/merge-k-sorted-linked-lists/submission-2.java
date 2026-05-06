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
    public ListNode mergeKLists(ListNode[] lists) {

            //I am using minHeap for solving this problem;
            PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

            //Add first node of each lists;
            for (ListNode node : lists) {
                if (node != null) {
                    pq.offer(node);
                }
            }

            ListNode dummy = new ListNode(-1);
            ListNode tail = dummy;

            while (!pq.isEmpty()) {
                ListNode node = pq.poll();

                tail.next = node;
                tail = tail.next;

                if (node.next != null) {
                    pq.offer(node.next);
                }
            }

            return dummy.next;
        }
    }
