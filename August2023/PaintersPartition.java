import java.util.*;

public class Solution 
{
    public static int computeTotalTime(ArrayList<Integer> boards,int t){
        int counter = 1;
        int totalTime = 0;
        for(int board=0;board<boards.size();board++){
            if(totalTime + boards.get(board) <= t){
                totalTime+=boards.get(board);
            }else{
                counter++;
                totalTime=boards.get(board);
            }
        }

        return counter;
    }

    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        //    Write your code here.
        int min = Collections.max(boards);
        int max = 0;

        //Brute Force
        if(k>boards.size()){
            return -1;
        }

        max =  boards.stream().mapToInt(Integer::intValue).sum();

        for(int i=min;i<max;i++){
            if(computeTotalTime(boards,i)<=k){
                return i;
            }
        }

        return max;
        
    }
}