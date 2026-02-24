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
    // List<String>  list ;

    public int sumRootToLeaf(TreeNode root) {
        
        // list = new ArrayList<>();
        sum =0;
        solve( root , "");
        // System.out.println(list);
        return sum;
    }
    public int sum =0 ;
    public void  solve(TreeNode root , String s ){
        if(root == null) return ;
        
        if( root.left == null && root.right == null){
            s += root.val+"";
            int val = Integer.parseInt(s, 2);
            sum+=val;
            return ;
        }

        solve(root.left , s+ root.val + "");
        solve(root.right , s+ root.val + "");
    } 
}

//T.C -> O(n)
//S.C -> O(n)