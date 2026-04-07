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
    public boolean check(TreeNode root, TreeNode subRoot, int check){

        if(root == null)
        {
            if(subRoot == null)
                return true;
            else
                return false;
        }
        if(subRoot == null)
            return false;
        
        boolean val = false;
        if(root.val == subRoot.val){
            val = val | (check(root.left, subRoot.left,1)&check(root.right, subRoot.right,1));   
        }
        if(check == 0)
        {
            val = val|check(root.right, subRoot,0);
            val = val|check(root.left, subRoot,0);
        }
        

        return val;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        return check(root, subRoot, 0);

    }
}
