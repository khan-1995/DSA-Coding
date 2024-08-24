class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        List<List<String>> sequences = new ArrayList<>();

        Queue<List<String>> queue = new LinkedList<>();
        List<String> usedWordsOnLevel = new ArrayList<>();

        queue.add(new ArrayList<>(Arrays.asList(beginWord)));
        usedWordsOnLevel.add(beginWord);

        Set<String> dist_set = new HashSet<>();
        dist_set.addAll(wordList);
        // dist_set.remove(beginWord);

        int level = 0;
        while(!queue.isEmpty()){
            List<String> seq = queue.poll();

            if(seq.size()>level){
                level++;
                for(String s : usedWordsOnLevel){
                    System.out.print(s+",");
                    dist_set.remove(s);
                }
                System.out.println("");
            }

            String word = seq.get(seq.size()-1);
            
            if(word.equals(endWord)){
                //accumulate to the final result
                // System.out.println(seq.get(seq.size()-1));
                if(sequences.isEmpty()){
                    sequences.add(seq);
                }else if(sequences.get(0).size()==seq.size()){
                    sequences.add(seq);
                }
            }

            // System.out.println(word);

            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] replacedChars  = word.toCharArray();
                    replacedChars[i] = ch;
                    String comb = new String(replacedChars);
                    if(dist_set.contains(comb)){
                        seq.add(comb);
                        usedWordsOnLevel.add(comb);
                        queue.add(new ArrayList<>(seq));
                        seq.remove(comb);
                    }
                }
            }
        }

        return sequences;
    }
}
