/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    List<int[]> list = new ArrayList<int[]>();
    public int check(TreeNode root, int l)
    {
        if(root == null)
        return 0;
        int level =  1 + Math.max(check(root.left, l+1), check(root.right, l+1));
        list.add(new int[]{root.val, l});
        return level;
    
    }
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        int level = check(root,0);
        for(int i=0;i<level;i++){
            List<Integer> array = new ArrayList<>();
            ans.add(array);
        }
        
        for(int i=0;i<list.size();i++)
        {
            ans.get(list.get(i)[1]).add(list.get(i)[0]);
        }
        return ans;
        
    }
}
