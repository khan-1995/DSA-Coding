class Solution {

    class Pair{
        String lock;
        int turns;
        public Pair(String lock,int turns){
            this.lock = lock;
            this.turns = turns;
        }
    }

    public String[] generateChildren(String lock){

        Set<String> list = new HashSet<>();
        int i = 0;
        for(char ch : lock.toCharArray()){
            int num = ch-'0';
            int n = (num+1)%10;
            int m = ((num-1)+10)%10;
            list.add(lock.substring(0,i)+String.valueOf(n)+lock.substring(i+1));
            list.add(lock.substring(0,i)+String.valueOf(m)+lock.substring(i+1));
            i++;
        }
        // list.forEach(System.out::println);
        return list.stream().toArray(String[]::new);
    }
    public int openLock(String[] deadends, String target) {

       List<String> deadendsList =  Arrays.asList(deadends);

        if(deadendsList.contains("0000")){
            return -1;
        }

        Queue<Pair> q = new LinkedList<Pair>();
        Set<String> visited = new HashSet<>();
        for(String s : deadendsList){
            visited.add(s);
        }
        q.offer(new Pair("0000",0));

        while(!q.isEmpty()){
            Pair p = q.poll();
            int turns = p.turns;

            if(p.lock.equals(target)){
               return p.turns;
            }
                String[] children = generateChildren(p.lock);
                for(String child : children){
                    // if(!deadendsList.contains(child)){
                        if(!visited.contains(child)){
                            visited.add(child);
                            q.offer(new Pair(child,turns+1));
                        }
                    // }
                }
        }

        return -1;
    }
}
