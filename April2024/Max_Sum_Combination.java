import java.util.Arrays;
public class Solution {
    class Pair{
        int first;
        int second;
        int sum;
        
        public Pair(int f,int s,int sum){
            this.first = f;
            this.second = s;
            this.sum = sum;
        }
    }
    public int[] solve(int[] A, int[] B, int C) {
        
        // System.out.print("Clear");
        PriorityQueue<Pair> maxHeap = new PriorityQueue<Pair>((a,b) ->  b.sum - a.sum);
        int n = A.length;
        List<Integer> a = Arrays.asList(A);
        List<Integer> b = Arrays.asList(B);
        Collections.sort(a,Collections.reverseOrder());
        Collections.sort(b,Collections.reverseOrder());
        A = a.stream().mapToInt(el -> el).toArray();
        B = b.stream().mapToInt(el -> el).toArray();
        
        maxHeap.offer(new Pair(0,0,A[0]+B[0]));
        List<Integer> list = new ArrayList<>();
        Set<int[]> set = new HashSet<>();
        
        for(int i=0;i<C;i++){
            Pair p = maxHeap.poll();
            list.add(p.sum);
            if(p.first+1<n && !set.contains(new int[]{p.first+1,p.second})){
                Pair new_p = new Pair(p.first+1,p.second,A[p.first+1]+B[p.second]);
                set.add(new int[]{p.first+1,p.second});
                maxHeap.offer(new_p);
            }
            if(p.second+1<n && !set.contains(new int[]{p.first,p.second+1})){
                Pair new_p = new Pair(p.first,p.second+1,A[p.first]+B[p.second+1]);
                set.add(new int[]{p.first,p.second+1});
                maxHeap.offer(new_p);
            }
        }
        
        // return list.stream().mapToInt(el -> el).toArray();
        return new int[]{};
    }
}
