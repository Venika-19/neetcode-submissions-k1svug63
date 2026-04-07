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

    public TreeNode[] check(TreeNode root, TreeNode p, TreeNode q){
        
        if(root == null)
            return new TreeNode[]{null, null};
        
        
        TreeNode[] arr = new TreeNode[2];
        TreeNode[] arr1 = new TreeNode[2];
        TreeNode[] arr2 = new TreeNode[2];
        
        if(root.val == p.val || root.val == q.val){
            arr[0] = root;
        }
        arr1 = check(root.left, p, q);
        arr2 = check(root.right, p, q);
        if(arr1[0]!=null && arr1[1]!=null)
            return arr1;
        if(arr2[0]!=null && arr2[1]!=null)
            return arr2;
        if((arr1[0]!=null && arr2[0]!=null) || (arr[0]!=null && arr1[0]!=null) || (arr[0]!=null && arr2[0]!=null)) {

            arr[0] = root;
            arr[1] = root;
            return arr;
        }
        else if(arr[0]!=null || arr1[0]!=null || arr2[0]!=null){
            return new TreeNode[]{root, null};
        }
            
        

        return new TreeNode[]{null, null};

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return check(root,p,q)[1];
        
    }
}
