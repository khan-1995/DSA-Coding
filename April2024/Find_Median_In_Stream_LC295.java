class MedianFinder {

    private PriorityQueue<Integer> minHeap = null;
    private PriorityQueue<Integer> maxHeap = null;
    public MedianFinder() {
        minHeap = new PriorityQueue<>((a,b) -> a-b);
        maxHeap = new PriorityQueue<>((a,b) -> b-a);
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || maxHeap.peek()>=num){
            maxHeap.offer(num);
        }else{
            minHeap.offer(num);
        }

        balance();
    }
    
    public double findMedian() {

        if(minHeap.size()>maxHeap.size()){
            return minHeap.peek();
        }else if(minHeap.size()<maxHeap.size()){
            return maxHeap.peek();
        }

        return (double) (maxHeap.peek()+minHeap.peek())/2;        
    }

    public void balance(){
        if(minHeap.size()-maxHeap.size()>1){
            maxHeap.offer(minHeap.poll());
        }else if(maxHeap.size()-minHeap.size()>1){
            minHeap.offer(maxHeap.poll());
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
