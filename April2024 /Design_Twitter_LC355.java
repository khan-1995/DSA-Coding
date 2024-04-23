class Twitter {

    Map<Integer, List<Integer>> userTweetMap;
    Map<Integer, Set<Integer>> followeeMap;
    Map<Integer, Integer> tweetIndexMap;
    int index;

    public Twitter() {
        userTweetMap = new LinkedHashMap<>();
        followeeMap = new HashMap<>();
        tweetIndexMap = new HashMap<>();
        index =0;
    }
    
    public void postTweet(int userId, int tweetId) {
        List<Integer> tweets = userTweetMap.getOrDefault(userId, new LinkedList<>());
        index++;
        tweetIndexMap.put(index, tweetId);
        tweets.add(index);
        userTweetMap.put(userId, tweets);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(10, (a, b) -> a-b);
        for(Integer tweetId : userTweetMap.getOrDefault(userId, new ArrayList<>())){
            pq.add(tweetId);
            if(pq.size()>10){
               pq.poll();
            }
        }
        for(Integer followee: followeeMap.getOrDefault(userId, Set.of())){
            for(Integer tweetId : userTweetMap.getOrDefault(followee, new ArrayList<>())){
                pq.add(tweetId);
                if(pq.size()>10){
                     pq.poll();
                }
            }
        }
        
        LinkedList<Integer> list = new LinkedList<>();
        while(!pq.isEmpty()){
            list.addFirst(tweetIndexMap.get(pq.poll()));
        }

        return list;
    }
    
    public void follow(int followerId, int followeeId) {
        
        Set<Integer> followees = followeeMap.getOrDefault(followerId, 
                new HashSet<>());     
        followees.add(followeeId);
        followeeMap.put(followerId, followees);

    }
    
    public void unfollow(int followerId, int followeeId) {
      
        Set<Integer> followees = followeeMap.getOrDefault(followerId, 
                new HashSet<>());   
        if(!followees.isEmpty())  
            followees.remove((Integer) followeeId);
        if(followees.isEmpty()){
            followeeMap.remove((Integer) followerId);
        } else {
            followeeMap.put(followerId, followees);
        }
        
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
