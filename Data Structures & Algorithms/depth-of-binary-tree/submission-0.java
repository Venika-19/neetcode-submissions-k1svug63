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

    public int length(TreeNode root){
        if(root == null)
            return 0;
        int length = 1 + Math.max(length(root.left), length(root.right));
        return length;
        
    }

    public int maxDepth(TreeNode root) {
        
        return length(root);
    }
}
