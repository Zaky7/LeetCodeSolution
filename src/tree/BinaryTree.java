package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
  private TreeNode root;
  private int size = 0;

  public void addNodeLevelOrderWise(Integer value, int index) {
    if (size == 0) {
      root = new TreeNode(value);
      size++;
    } else {
      addNodeLevelOrderWise(root, value, index);
    }
  }

  /**
   *
   * @param currentNodeIndex Current Node index
   * @param index index of value in the list
   * @return True if Current Node Index is parent of given index
   */
  private boolean isParentOf(int currentNodeIndex, int index) {
    int parentIndex = (int) Math.floor((index - 1) / 2);
    return parentIndex == currentNodeIndex;
  }

  private boolean isOccurLeft(int index, int matchIndex) {
    return (2 * index + 1) == matchIndex;
  }

  private TreeNode addNodeLevelOrderWise(TreeNode rootNode, Integer value, int index) {
    /* If root is null, return null */
    if (rootNode == null) {
      return null;
    }

    // If added value is not null insert into current Binary Tree
    if (value != null) {
      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(rootNode);
      int nodeIndex = -1;
      TreeNode newNode = new TreeNode(value);

      // Add the current tree Node to Queue and iterate over it until suitable position find
      while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        nodeIndex++;

        if (node != null && isParentOf(nodeIndex, index)) {
          if (node.left == null || node.right == null) {
            if (isOccurLeft(nodeIndex, index)) {
              node.left = newNode;
            } else {
              node.right = newNode;
            }
            break;
          }
        }

        if (node == null) {
          queue.add(null);
          queue.add(null);
        } else {
          queue.add(node.left != null ? node.left : null);
          queue.add(node.right != null ? node.right : null);
        }
      }
    }

    size++;
    return rootNode;
  }

  public TreeNode root() {
    if (isEmpty()) {
      return null;
    } else {
      return root;
    }
  }

  /**
   * Check whether Binary Tree is Empty or not
   *
   * @return the Size of Binary Tree
   */
  public boolean isEmpty() {
    return size() == 0;
  }

  public int size() {
    return size(root);
  }

  /**
   * Size of Binary Tree
   *
   * @param root
   * @return
   */
  private int size(TreeNode root) {
    if (root != null) {
      return 1 + Math.max(size(root.left), size(root.right));
    } else {
      return 0;
    }
  }

  /**
   * @param node
   * @return True if a given node is root else False
   */
  public boolean isRoot(TreeNode node) {
    return root == node;
  }

  public TreeNode findParent(TreeNode node) {
    return findParent(node.val, root, null);
  }

  private TreeNode findParent(int data, TreeNode root, TreeNode parent) {
    if (root == null) {
      return null;
    }

    // Compare with root if found equal return parent
    // else find parent in left subtree if not found then find parent in Right subTree.
    if (root.val != data) {
      parent = findParent(data, root.left, parent);
      if (parent == null) {
        parent = findParent(data, root.right, parent);
      }
    }

    return parent;
  }

  /**
   * Method for finding if a node has Parent
   *
   * @param node
   * @return
   */
  public boolean hasParent(TreeNode node) {
    return findParent(node) != null;
  }

  /***
   * Method to check if given Node has right
   */
  public boolean hasRight(TreeNode node) {
    return node.right != null;
  }

  /**
   * Find the Right Node of given Node
   *
   * @param node
   * @return
   */
  public TreeNode right(TreeNode node) {
    if (hasRight(node)) return node.right;
    return null;
  }

  /***
   * Method to check if given Node has Left
   */
  public boolean hasLeft(TreeNode node) {
    return node.left != null;
  }

  /**
   * Find the left Node of given Node
   *
   * @param node
   * @return
   */
  public TreeNode left(TreeNode node) {
    if (hasLeft(node)) return node.left;
    return null;
  }

  /**
   * Method to check if is a leaf Node
   *
   * @param node
   * @return
   */
  public boolean isleaf(TreeNode node) {
    return !hasLeft(node) && !hasRight(node);
  }

  /**
   * Method to get depth of the tree
   * This is considered as Level as well
   *
   * @param node
   * @return {@link int}
   */
  public int getDepth(TreeNode node) {
    /* If given node is null, size is zero */
    if (node == null) {
      return 0;
    }
    /* Get the depth of left and right.
     * Whichever is greater, return that and add
     * one for root */
    int left = getDepth(node.left);
    int right = getDepth(node.right);
    return left > right ? left + 1 : right + 1;
  }

  /**
   * Method to print the tree InOrder
   * InOrder : Left -> Root -> Right
   *
   * @param node
   */
  public void printInOrder(TreeNode node) {
    /* If root is null, return else print
     * in order specified above */
    if (node == null) {
      return;
    }
    printInOrder(node.left);
    System.out.print(node.val + " ");
    printInOrder(node.right);
  }

  /**
   * Method to print the tree PreOrder
   * PreOrder : Root -> Left -> Right
   *
   * @param node
   */
  public void printPreorder(TreeNode node) {
    /* If root is null, return else print
     * in order specified above */
    if (node == null) {
      return;
    }

    if (node.val == 0) {
      System.out.print("null" + " ");
    } else {
      System.out.print(node.val + " ");
    }

    printPreorder(node.left);
    printPreorder(node.right);
  }

  /**
   * Method to print the tree PostOrder
   * PostOrder : Left -> Right -> Root
   *
   * @param node
   */
  public void printPostorder(TreeNode node) {
    /* If root is null, return else print
     * in order specified above */
    if (node == null) {
      return;
    }
    printPostorder(node.left);
    printPostorder(node.right);
    System.out.print(node.val + " ");
  }
}
