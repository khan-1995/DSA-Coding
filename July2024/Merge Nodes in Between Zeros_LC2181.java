class Solution {
    public ListNode mergeNodes(ListNode head) {

        ListNode curr = head.next;
        
        int sum = 0;
        ListNode prev = new ListNode(0,null);
        ListNode ansHead = prev;

        while(curr!=null){
            if(curr.val!=0){
                sum+=curr.val;
            }else{
                curr.val = sum;
                prev.next = curr;
                prev = curr;
                sum = 0;
            }
            curr = curr.next;
        }

        return ansHead.next;
    }
}
