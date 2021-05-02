package src.tree;

public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode() {

  }

  public TreeNode(int item) {
    this.val = item;
    this.left = null;
    this.right = null;
  }

  public TreeNode(int item, TreeNode left, TreeNode right) {
    this.val = item;
    this.left = left;
    this.right = right;
  }
}

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
