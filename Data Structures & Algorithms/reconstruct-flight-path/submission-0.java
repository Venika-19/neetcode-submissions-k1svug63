class Solution {
    Map<String, List<String>> adjList;
    public boolean dfs(int edges, List<String> res, String s){

        if(res.size() == edges + 1)
            return true;
        
        if(!adjList.containsKey(s))
            return false;

        List<String> temp = new ArrayList<>(adjList.get(s));

        for(int i=0;i< temp.size();i++){

            String v = temp.get(i);
            adjList.get(s).remove(v);
            res.add(v);
            if(dfs(edges, res, v))  return true;
            adjList.get(s).add(i, v);
            res.remove(res.size() - 1);

        }        

        return false;

    }
    public List<String> findItinerary(List<List<String>> tickets) {
        
        adjList = new HashMap<>();
        tickets.sort((a,b) -> a.get(1).compareTo(b.get(1)));
        for(List<String> itr: tickets){
            if(adjList.containsKey(itr.get(0)))
                adjList.get(itr.get(0)).add(itr.get(1));
            else{
                adjList.put(itr.get(0), new ArrayList<>());
                adjList.get(itr.get(0)).add(itr.get(1));
            }
        }


        
        int edges = tickets.size();
        List<String> res = new ArrayList<>();
        res.add("JFK");

        if(dfs(edges, res, "JFK"))
            return res;

        return new ArrayList<>();
        
        
    }
}
