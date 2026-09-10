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
    public int res =0 ; 
    public int averageOfSubtree(TreeNode root) {
        if(root == null) return 0 ;

        solve(root);
        return res ;
        
    }

    public int [] solve(TreeNode root){

        if(root == null) return new int [] {0,0}; // sum , count n

        int left[] = solve(root.left);
        int right[] = solve(root.right);
        
        int sum = left[0] + right[0] + root.val;
        int n = left[1] + right[1] + 1;
        if( (sum / n) == root.val) res++;


        return new int [] { sum , n };
        
    } 
}