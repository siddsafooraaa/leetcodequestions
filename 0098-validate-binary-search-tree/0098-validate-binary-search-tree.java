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
    ArrayList<TreeNode> list=new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).val <= list.get(i - 1).val) {
                return false;
            }
        }
        return true;
    }
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }
}
