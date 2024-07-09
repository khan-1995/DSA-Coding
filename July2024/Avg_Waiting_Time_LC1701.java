// class Solution {
//     public double averageWaitingTime(int[][] customers) {

//         int total_customers = customers.length;
//         int range_start = customers[0][0];
//         int range_end = range_start+customers[0][1];

//         int arrival_time = 0;
//         int preparation_time = 0;
//         int total_time = 0;
        
//         for(int i=0;i<total_customers;i++){
//             arrival_time = customers[i][0];
//             preparation_time = customers[i][1];
            
//             if(arrival_time>=range_start && arrival_time<range_end && i>0){
//                 total_time += preparation_time+(range_end - arrival_time);
//                 range_start = range_end;
//                 range_end = range_start + preparation_time;
//             }else{
//                 range_start = arrival_time;
//                 range_end = range_start + preparation_time;
//                 total_time += (range_end - range_start);
//             }
//             // System.out.println(range_start+" "+range_end);
//         }
//         // System.out.println(total_time);

//         return ((double)total_time/(double)total_customers);
//     }
// }
class Solution {

    public double averageWaitingTime(int[][] customers) {
        int nextIdleTime = 0;
        long netWaitTime = 0;

        for (int i = 0; i < customers.length; i++) {
           
            nextIdleTime = Math.max(customers[i][0], nextIdleTime) +
            customers[i][1];

            
            netWaitTime += nextIdleTime - customers[i][0];
        }

        double averageWaitTime = (double) netWaitTime / customers.length;
        return averageWaitTime;
    }
}
