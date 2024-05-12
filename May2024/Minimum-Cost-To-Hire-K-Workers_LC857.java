class Solution {
    class Pair{
        double ratio;
        int qlty;

        public Pair(double r,int q){
            this.ratio = r;
            this.qlty = q;
        }
    }
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        
        List<Pair> list = new ArrayList<>();

        for(int i=0;i<quality.length;i++){
            double ratio = wage[i]/(double) quality[i];
            list.add(new Pair(ratio,quality[i]));
        }

        Collections.sort(list,(a,b)->  Double.compare(a.ratio,b.ratio));

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a,b)-> b.qlty-a.qlty);

        double totalQlty = 0;
        double ans = Integer.MAX_VALUE;

        for(Pair p : list){
            maxHeap.offer(p);
            totalQlty+=p.qlty;

            if(maxHeap.size()>k){
                Pair maxP = maxHeap.poll();
                totalQlty-=maxP.qlty;
            }

            if(maxHeap.size()==k){
                ans = Math.min(ans,totalQlty*p.ratio);
            }

        }
        
        return ans;
    }
}
