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

    public ListNode reverse(ListNode head){

        ListNode next = null;
        ListNode prev = null;
        ListNode current = head;

        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
    public ListNode doubleIt(ListNode head) {

        if(head==null){
            return head;
        }

        // if(head.next==null){
        //     head.val = 2*head.val;
        //     return head;
        // }

        ListNode rHead = reverse(head);
        ListNode prev = null;
        ListNode temp = rHead;
        int carry = 0;

        while(temp!=null){
            int num = 2*temp.val+carry;
            temp.val = num%10;
            carry = num/10;
            prev = temp;
            temp = temp.next;
        }
        if(carry>0){
            prev.next = new ListNode(carry,null);
        }
        return reverse(rHead);
    }
}
