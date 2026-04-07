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

    public int[] height(TreeNode root){

        if(root == null)
            return new int[]{0,1};
        
        int[] h1 = height(root.left);
        int[] h2 = height(root.right);
        int[] arr = new int[2];
        arr[1] = 1;
        if(Math.abs(h1[0]-h2[0]) > 1){
            arr[1] = 0; 
        }

        arr[1] = Math.min(Math.min(h1[1], h2[1]), arr[1]);
        arr[0] = 1+Math.max(h1[0], h2[0]);
        return arr;
        
    }
    public boolean isBalanced(TreeNode root) {


        return height(root)[1] == 1;

        
    }
}
