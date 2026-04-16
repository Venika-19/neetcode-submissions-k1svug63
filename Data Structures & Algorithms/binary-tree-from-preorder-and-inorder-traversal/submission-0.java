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

    public void create(int[] preorder , int i, int j, TreeNode root, int[] inorder, int ii, int jj){

        if(i == j || ii ==jj)
            return;

        int rVal = root.val;
        int ind = 0;
        for(int k = ii; k<=jj;k++){
            if(inorder[k] == rVal){
                ind = k;
                break;
            }
        }
        if(ind - ii -1 >= 0){
            root.left = new TreeNode(preorder[i+1]);
            create(preorder, i+1, i + ind - ii, root.left, inorder, ii, ind-1);
        }
        if(jj - ind - 1 >= 0){
            root.right = new TreeNode(preorder[i + ind - ii + 1]);
            create(preorder, i + ind - ii + 1, j, root.right, inorder, ind+1, jj);
        }

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        TreeNode root =  new TreeNode(preorder[0]);

        create(preorder, 0, preorder.length-1,root, inorder, 0, preorder.length -1);

        return root;
        
    }
}
