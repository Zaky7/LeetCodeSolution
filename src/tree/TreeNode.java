package tree;

public class TreeNode {
  public int val;
  public TreeNode left, right;

  public TreeNode(int item) {
    val = item;
    left = right = null;
  }

  public TreeNode(int item, TreeNode left, TreeNode right) {
    this.val = item;
    this.left = left;
    this.right = right;
  }
}
