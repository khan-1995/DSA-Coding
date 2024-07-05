class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        if(head==null || head.next==null || head.next.next==null){
            return new int[]{-1,-1};
        }

        int firstPos = -1;
        int prevPos = -1;
        int lastPos = -1;


        ListNode prev = head;
        ListNode curr = prev.next;
        ListNode next = curr.next;
        int index = 1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while(next!=null){

            if(prev.val<curr.val && curr.val>next.val || prev.val>curr.val && curr.val<next.val){
                if(firstPos==-1){
                    firstPos = index;
                }
                prevPos = lastPos;
                lastPos = index;
            }

            if(lastPos >0 && prevPos>0){
                max = Math.max((lastPos - firstPos),max);
                min = Math.min((lastPos - prevPos),min);
            }

            prev = curr;
            curr = next;
            next = next.next;
            index++;
        }

        if(lastPos==-1 || prevPos==-1 || firstPos==-1){
            return new int[]{-1,-1};
        }
        
        return  new int[]{min,max};
    }
}
