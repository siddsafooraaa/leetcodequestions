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
    public int kthSmallest(TreeNode root, int k) {
       inorder(root);
       for(int i=0;i<list.size();i++){
        if(i==k-1){
            return list.get(i).val;
        }
       }
       return -1;
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