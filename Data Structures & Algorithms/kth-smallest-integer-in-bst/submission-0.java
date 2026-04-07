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
    int val;
    public int check(TreeNode root){

        if(root == null)
            return -1;
        
        int ret1 = check(root.left);
        if(ret1!=-1)
            return ret1;
        val--;
        if(val == 0)
        return root.val;
        int ret2 = check(root.right);
        if(ret2!=-1)
            return  ret2;
        return -1;
    }
    public int kthSmallest(TreeNode root, int k) {
        val = k;
        return check(root);
    }
}
