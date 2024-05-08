class Solution {
    public String[] findRelativeRanks(int[] score) {
        
        int[] newScore = Arrays.copyOf(score,score.length);
        Arrays.sort(newScore);
        Map<Integer,String> map = new HashMap<>();

        String[] medals =new String[]{"Gold Medal","Silver Medal","Bronze Medal"};
        String[] res =new String[score.length];
        int n = score.length-1;
        for(int j=newScore.length-1;j>=0;j--){
            if((n-j)<medals.length){
                map.put(newScore[j],medals[n-j]);
            }else{
                map.put(newScore[j],""+(n-j+1));
            }
        }

        for(int i=0;i<score.length;i++){
            res[i] = map.get(score[i]);
        }

        return res;
    }
}
