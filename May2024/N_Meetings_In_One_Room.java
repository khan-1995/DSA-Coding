//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class Meeting{
        
        int start;
        int end;
        int pos;
        
        public Meeting(int s,int e,int p){
            this.start = s;
            this.end = e;
            this.pos = p;
        }
        
    }
class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        int max = 0;
        
        // int prevStart = start[0];
        int prevEnd = 0;
        List<Meeting> meetings = new ArrayList<>();
        for(int i=0;i<n;i++){
            meetings.add(new Meeting(start[i],end[i],i));
        }
        
        // Sort the meetings by end time
        Collections.sort(meetings,(a,b) -> a.end-b.end);
        
        for(int i=0;i<n;i++){
            Meeting m = meetings.get(i);
            if(m.start > prevEnd){
                max++;
                prevEnd = m.end;
            }
        }
        
        return max;
    }
}
