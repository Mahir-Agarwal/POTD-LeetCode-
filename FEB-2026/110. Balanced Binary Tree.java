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
    public boolean isBalanced(TreeNode root) {
        
        if(root ==null){
            return true;
        }

        int left = height (root.left);
        int right =height(root.right);


        return Math.abs(left-right) <=1 && (isBalanced(root.left) && isBalanced( root.right));
    }

    public int height (TreeNode root){

        if(root ==null) return 0;

        return Math.max(height(root.left),height(root.right))+1;
    }

    
}

// T.C -> O(n^2)
// S.C -> O(n) in worst case when tree is skewed and O(log n)

// 2nd optimsed solution

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
    public boolean isBalanced(TreeNode root) {
        
        if(root ==null){
            return true;
        }

    

        return (height(root)==-1 ? false : true);
    }

    public int height (TreeNode root){

        if(root ==null) return 0;

        int left = height(root.left);
        if(left ==-1) return  -1;
        int right = height (root.right);

        if(right == -1) return -1;

        if(Math.abs(left-right)>1) return -1;

        return Math.max(left,right)+1;
    }

    
}

// T.C -> O(n)
// S.C -> O(n) in worst case when tree is skewed and O(log n)