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
    public int[] diameter(TreeNode root)
    {

        if(root == null)
            return new int[]{0,0};
        int[] arr1 = new int[2] , arr2 = new int[2] , arr = new int[2];
        arr1 = diameter(root.left);
        arr2 = diameter(root.right);
        arr[0] = 1 + Math.max(arr1[0], arr2[0]);
        arr[1] = Math.max(Math.max(arr1[1], arr2[1]), arr1[0] + arr2[0] + 1);

        return arr;

        
    }
    public int diameterOfBinaryTree(TreeNode root) {

        
        return diameter(root)[1] - 1;

        
    }
}
