package tree.maxwidth;

import com.sun.source.tree.Tree;
import java.util.*;
import tree.BinaryTree;
import tree.TreeNode;

public class MaxWidth {

  class TreeNodeWithIndex {
    private TreeNode node = null;
    private int treeIndex = 0;

    TreeNodeWithIndex(TreeNode node, int index) {
      this.node = node;
      this.treeIndex = index;
    }
  }

  private int getEffectiveWidth(LinkedList<TreeNodeWithIndex> queue) {
    TreeNodeWithIndex firstNode = queue.getFirst();
    TreeNodeWithIndex lastNode = queue.getLast();
    int startIndex = firstNode.treeIndex;
    int endIndex = lastNode.treeIndex;
    // System.out.println("StartIndex: " + startIndex  + " Start Value: " + firstNode.node.val + " EndIndex: " + endIndex + " End Val: " + lastNode.node.val);
    return endIndex - startIndex + 1;
  }

  public int widthOfBinaryTree(TreeNode root) {
    if (root == null) {
      return 0;
    }

    LinkedList<TreeNodeWithIndex> queue = new LinkedList<>();
    int max_width = Integer.MIN_VALUE;
    queue.add(new TreeNodeWithIndex(root, 0));

    while (!queue.isEmpty()) {
      int queueSize = queue.size();
      max_width = Math.max(max_width, getEffectiveWidth(queue));

      while (queueSize > 0) {
        // Dequeue fom node
        TreeNodeWithIndex nodeWithIndex = queue.remove();
        TreeNode node = nodeWithIndex.node;

        int nodeStartIndex = 2 * nodeWithIndex.treeIndex + 1;
        queueSize--;
        if (node.left != null) {
          queue.add(new TreeNodeWithIndex(node.left, nodeStartIndex));
        }

        nodeStartIndex++;
        if (node.right != null) {
          queue.add(new TreeNodeWithIndex(node.right, nodeStartIndex));
        }
      }
    }

    return max_width;
  }

  /*
   * Utility for Adding arr element to Tree DataStructure
   */
  private BinaryTree addArr(Integer[] arr, BinaryTree bTree) {
    int index = 0;
    for (Integer i : arr) {
      bTree.addNodeLevelOrderWise(i, index++);
    }
    return bTree;
  }

  public static void main(String[] args) {
    BinaryTree bTree = new BinaryTree();
    //        Integer[] arr = {1,1,1,1,1,1,1,null,null,null,1,null,null,null,null,2,2,2,2,2,2,2,null,2,null,null,2,null,2};
    //        Integer[ ] arr = {1,2,3, 4, null, null, 5, 7, null, null, null, null, null, null, 8};
    Integer[] arr = {
      1,
      7,
      null,
      5,
      null,
      null,
      null,
      7,
      9,
      null,
      null,
      null,
      null,
      null,
      null,
      8,
      null,
      null,
      10,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
    };

    // Add the Element in the Array
    MaxWidth mw = new MaxWidth();
    mw.addArr(arr, bTree);

    // Get the root
    TreeNode root = bTree.root();
    System.out.println(
      "Max width of binary Tree: " + mw.widthOfBinaryTree(root)
    );
  }
}
