/**
 * Definition for a binary tree node.*/
 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        return Math.abs(leftHeight-rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right);

    }
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftH = maxDepth(root.left);
        int rightH = maxDepth(root.right);
        return leftH > rightH ? leftH+1 : rightH+1;
    }
}