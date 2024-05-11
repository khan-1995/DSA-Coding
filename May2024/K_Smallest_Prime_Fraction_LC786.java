class Solution {
     public int[] getCount(int[] arr,double target){

        int count = 0;
        int n = arr.length;
        int numer = arr[0];
        int denom = arr[n-1];
        int i=0;
        for(int j=1;j<arr.length;j++){
            
            while((arr[i]/(double) arr[j]) <=target){
                i++;
            }
            count+=i;

            if(i>0 && (arr[i-1]/(double)arr[j])>(numer/(double) denom)){
                numer = arr[i-1];
                denom = arr[j];
            }
        }

        return new int[]{count,numer,denom};
    }
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        // Create a priority queue to store pairs of fractions
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        // Push the fractions formed by dividing each element by
        // the largest element into the priority queue
        for (int i = 0; i < arr.length; i++) {
            pq.offer(new double[] {
                -1.0 * arr[i] / arr[arr.length - 1], 
                i, 
                arr.length - 1
            });
        }

        // Iteratively remove the top element (smallest fraction) 
        // and replace it with the next smallest fraction
        while (--k > 0) {
            double[] cur = pq.poll();
            int numeratorIndex = (int) cur[1];
            int denominatorIndex = (int) cur[2] - 1;
            if (denominatorIndex > numeratorIndex) {
                pq.offer(new double[] {
                        -1.0 * arr[numeratorIndex] / arr[denominatorIndex], 
                        numeratorIndex, 
                        denominatorIndex
                });
            }
        }

        // Retrieve the kth smallest fraction from 
        // the top of the priority queue
        double[] result = pq.poll();
        return new int[]{arr[(int) result[1]], arr[(int) result[2]]};
        /*Optimized O(logn)
           double low = 0.0;
           double high = 1.0;

            while(low<high){
                double mid = (double)((low+high)/2);
    
                int[] count = getCount(arr,mid);
                if(count[0]==k){
                    return new int[]{count[1],count[2]};
                }else if(count[0]>k){
                    high = mid;
                }else{
                    low = mid;
                }
            }

            return null;
        */
    }
}
