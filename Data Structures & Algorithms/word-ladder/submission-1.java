class Solution {
    Map<String, List<String>> adjList;
    public boolean check(String a, String b){
        
        int ans = 0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i) == b.charAt(i))
                ans++;
        }

        return ans == a.length() - 1;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        adjList = new HashMap<>();

        wordList.add(beginWord);
        for(int i=0;i<wordList.size();i++){
            adjList.put(wordList.get(i), new ArrayList<>());
            for(String itr: adjList.keySet()){
                if(check(wordList.get(i), itr)){
                    adjList.get(itr).add(wordList.get(i));
                    adjList.get(wordList.get(i)).add(itr);
                }
            }
        }

        Queue<String> pq = new LinkedList<>();
        pq.add(beginWord);
        int ans = 0;
        Map<String, Integer> visited = new HashMap<>();
        visited.put(beginWord, 1);
        while(!pq.isEmpty()){
            
            String s = pq.poll();
            if(s.equals(endWord))
                return visited.get(s);
            for(String t: adjList.get(s)){
                if(!visited.containsKey(t)){
                    pq.add(t);
                    visited.put(t, visited.get(s) + 1);
                }
                    
            }
           
        }

        return 0;
    }
}
