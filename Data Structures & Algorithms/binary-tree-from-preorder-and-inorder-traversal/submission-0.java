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
        int preIndex = 0;
        public TreeNode buildTree(int[] preorder, int[] inorder) {

            Map<Integer, Integer> inorderMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                inorderMap.put(inorder[i], i);
            }

            return helper(preorder, 0, inorder.length - 1, inorderMap);
        }

        public TreeNode helper(int[] preorder, int inStart, int inEnd, Map<Integer, Integer> inOrderMap) {

            if (inStart > inEnd) {
                return null;
            }

            int rootVal = preorder[preIndex++];
            int inIndex = inOrderMap.get(rootVal);

            TreeNode root= new TreeNode(rootVal);

            root.left = helper(preorder, inStart, inIndex - 1, inOrderMap);
            root.right = helper(preorder, inIndex + 1, inEnd, inOrderMap);

            return root;
        }
    }