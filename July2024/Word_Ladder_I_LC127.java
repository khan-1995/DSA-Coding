class Solution {
  //T.C len(word) * 26

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<Pair<String,Integer>> queue = new LinkedList<>();
        queue.add(new Pair(beginWord,1));
        Set<String> dist_set = new HashSet<>();

        dist_set.addAll(wordList);
        dist_set.remove(beginWord);

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            String word = (String) p.getKey();
            Integer steps = (Integer) p.getValue();

            if(word.equals(endWord)){
                return steps;
            }
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] replacedChars  = word.toCharArray();
                    replacedChars[i] = ch;
                    String comb = new String(replacedChars);
                    if(dist_set.contains(comb)){
                        queue.add(new Pair(comb,steps+1));
                        dist_set.remove(comb);
                    }
                }
            }
        }

     return 0;
    }
}
