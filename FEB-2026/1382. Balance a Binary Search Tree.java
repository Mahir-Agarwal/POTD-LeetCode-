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
    public TreeNode balanceBST(TreeNode root) {
        
        List<Integer> res = new ArrayList<>();

        inorder(res , root);

        return solve(res , 0 ,res.size()-1);

    }

    public TreeNode solve(List<Integer> res ,int s , int e){

        if( s>e) return null;
        int mid = s+ (e-s)/2;

        int val = res.get(mid);

        TreeNode root =  new TreeNode(val);

        root.left =  solve(res , s , mid-1);
        root.right =  solve(res , mid+1,e);

        return root;
    }

    public void inorder(List<Integer> res , TreeNode root){

        if(root ==null) return ;

        inorder(res, root.left);
        res.add(root.val);
        inorder(res, root.right);
    }
}

//T.C -> O(N) + O(N) => O(N)
//S.C -> O(N) + O(N) => O(N)