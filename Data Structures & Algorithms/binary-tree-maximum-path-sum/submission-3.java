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
    public int[] check(TreeNode root){

        if(root == null)
            return new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        int[] ans = new int[2];
        int[] right = check(root.right);
        int[] left = check(root.left);
        int max = Math.max(right[0], left[0]);
        ans[0] = root.val;
        if(max > 0)
        ans[0]+= max;
        ans[1] = root.val;
        if(right[0] > 0)
        ans[1]+= right[0];
        if(left[0] > 0)
        ans[1]+= left[0];
        ans[1] = Math.max(ans[1], Math.max(right[1], left[1]));
        ans[1] = Math.max(ans[1], ans[0]);
        return ans;
    }
    public int maxPathSum(TreeNode root) {

        int[] ans = check(root);
        return ans[1];
        
    }
}
