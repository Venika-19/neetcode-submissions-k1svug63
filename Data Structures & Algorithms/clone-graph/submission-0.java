/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Integer, Node> visited = new HashMap<>();

    public void dfs(Node node){

        for(Node temp: node.neighbors){
            if(visited.get(temp.val) == null){
                Node newNode = new Node(temp.val);
                visited.put(temp.val, newNode);
                dfs(temp); 
                visited.get(node.val).neighbors.add(newNode);   
            }else{
                visited.get(node.val).neighbors.add(visited.get(temp.val));
            }
            
        }
        
        

    }

    public Node cloneGraph(Node node) {

        if(node == null)
            return null;

        Node newNode = new Node(node.val);
        visited.put(node.val, newNode);
        dfs(node);

        return newNode;
    }
}