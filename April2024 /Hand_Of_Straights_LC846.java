class Solution {

class Pair{
        int size;
        int prev;
        Pair(int _s, int _p){
            size = _s;
            prev = _p;
        }
    }
    public boolean isNStraightHandOptimized(int[] hand, int groupSize) {
        if(groupSize == 1) return true;
        Arrays.sort(hand);
        if(hand.length % groupSize != 0) return false;
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)->a.prev - b.prev
        );
        for(int h : hand){
            if(!pq.isEmpty() && h - pq.peek().prev == 1){
                Pair p = pq.poll();
                p.size++;
                p.prev = h;
                if(p.size != groupSize)
                    pq.offer(p);
            }
            else{
                pq.offer(new Pair(1, h));
            }
        }
        return pq.isEmpty();
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {

        if(hand.length%groupSize!=0){
            return false;
        }

        Map<Integer,Integer> count_map = new HashMap<>();
        
        for(int n: hand){
            count_map.put(n,count_map.getOrDefault(n,0)+1);
        }

        int[] sorted_hand = count_map.keySet().stream().mapToInt(Integer::intValue).toArray();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int m : sorted_hand){
            pq.offer(m);
        }
    

        while(!pq.isEmpty()){

            int min = pq.peek();

            

            for(int i=min;i<(min+groupSize);i++){
                if(!count_map.containsKey(i)){
                    return false;
                }
                int freq = count_map.get(i)-1;
                count_map.put(i,freq);
                if(freq==0){
                    if(i!=pq.peek()){
                        return false;
                    }
                    pq.poll();
                    count_map.remove(i);
                    // System.out.print(val);
                }
            }
        }

        return true;
    }
}
