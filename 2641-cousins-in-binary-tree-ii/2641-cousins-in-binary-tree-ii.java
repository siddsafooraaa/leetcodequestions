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
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        ArrayList<Integer> levelSum = new ArrayList<>();
        while (!que.isEmpty()) {
            int n = que.size();
            int currLevelSum = 0;
            for (int j = 0; j < n; j++) {
                TreeNode curr = que.poll();
                currLevelSum +=curr.val;
                if (curr.left != null) {
                    que.add(curr.left);
                }
                if (curr.right != null) {
                    que.add(curr.right);
                }
            }
            levelSum.add(currLevelSum);
        }
        que.add(root);
        root.val = 0;
        int i = 1;
        while (!que.isEmpty()) {
            int n = que.size();
            for (int j = 0; j < n; j++) {
                TreeNode curr = que.poll();
                int siblingSum = 0;
                if (curr.left != null) {
                    siblingSum += curr.left.val;
                }
                if (curr.right != null) {
                    siblingSum += curr.right.val;
                }
                if (curr.left != null) {
                    curr.left.val = levelSum.get(i) - siblingSum;
                    que.add(curr.left);
                }
                if (curr.right != null) {
                    curr.right.val = levelSum.get(i) - siblingSum;
                    que.add(curr.right);
                }
            }
            i++;
        }
        return root;
    }
}