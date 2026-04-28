class Twitter {
    HashMap<Integer, List<int[]>> posts;
    HashMap<Integer, List<Integer>> follows;
    Integer time = 0;
    public Twitter() {
        posts = new HashMap<>();
        follows = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        time++;
        if(!posts.containsKey(userId))
            posts.put(userId, new ArrayList<>());
        posts.get(userId).add(new int[]{time, tweetId});
        
        if(!follows.containsKey(userId)){
            follows.put(userId, new ArrayList<>());
            follows.get(userId).add(userId);
        }
        
    }
    
    public List<Integer> getNewsFeed(int userId) {
        
        List<int[]> feed = new ArrayList<>();
        if (!follows.containsKey(userId)) {
            follows.put(userId, new ArrayList<>());
            follows.get(userId).add(userId);
        }
        List<Integer> parse = follows.get(userId);
        for(int itr: parse){
            if(posts.containsKey(itr))
            for(int[] e: posts.get(itr)){
                feed.add(e);
            }
        }
        feed.sort((a,b) -> Integer.compare(b[0], a[0]));
        List<Integer> ans = new ArrayList<>();
        int ptr = 0;
        while(ptr < 10 && ptr < feed.size()){
            ans.add(feed.get(ptr)[1]);
            ptr++;
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {

        follows.putIfAbsent(followerId, new ArrayList<>());
        if (!follows.get(followerId).contains(followeeId)) 
            follows.get(followerId).add(followeeId);
        
    }
    
    public void unfollow(int followerId, int followeeId) {

        if (followeeId == followerId) return;

        if(follows.containsKey(followerId) && follows.get(followerId).contains(followeeId))
            follows.get(followerId).remove(Integer.valueOf(followeeId));
        
    }
}
