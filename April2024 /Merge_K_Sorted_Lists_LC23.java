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
    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        ListNode head = new ListNode(0,null);
        ListNode tail = head;

        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        if(l1!=null){
            tail.next = l1;
        }

        if(l2!=null){
            tail.next = l2;
        }

        return head.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length==0 || lists==null){
            return null;
        }

        while(lists.length>1){
            ArrayList<ListNode> mergedList = new ArrayList<>();

            for(int i=0;i<lists.length;i+=2){
                ListNode l1 = lists[i];
                ListNode l2 = null;
                if(i+1<lists.length){
                  l2 = lists[i+1];
                }
                mergedList.add(mergeTwoLists(l1,l2));
            }

            lists = mergedList.toArray(new ListNode[mergedList.size()]);
        }

        return lists[0];

        // PriorityQueue<Integer> pq = new PriorityQueue<>();

        // for(ListNode node : lists){
        //     while(node!=null){
        //      pq.add(node.val);
        //      node = node.next;
        //     }
        // }

        // ListNode head = new ListNode(0,null);
        // ListNode temp = head;

        // while(!pq.isEmpty()){
        //     int num = pq.poll();
        //     temp.next = new ListNode(num,null);
        //     temp = temp.next;
        // }

        // return head.next;


    }
}
