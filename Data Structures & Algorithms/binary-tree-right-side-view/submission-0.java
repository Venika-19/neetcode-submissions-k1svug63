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
    List<Integer> list = new ArrayList<>();
    HashSet<Integer> set = new HashSet<>();
    public void check(TreeNode root, int level)
    {
        if(root == null)
        return;
        if(!set.contains(level)){
            list.add(root.val);
            set.add(level);
        }
        check(root.right, level +1);
        check(root.left, level + 1);
    }
    public List<Integer> rightSideView(TreeNode root) {
         
        check(root,0);
        return list;
        
    }
}
