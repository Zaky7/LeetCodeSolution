package array;

import tree.TreeNode;

class BSTFromPreOrder {

  public TreeNode bstFromPreorder(int[] preorder) {
    return bstFromPreorderUtil(preorder, 0, preorder.length - 1);
  }

  private TreeNode createNodeFactory(int val) {
    return new TreeNode(val, null, null);
  }

  private TreeNode bstFromPreorderUtil(int[] preorder, int start, int end) {
    if (start == end) {
      return createNodeFactory(preorder[start]);
    }

    TreeNode root = createNodeFactory(preorder[start]);

    int nextGreaterIndex = findNextGreaterIndex(preorder, start, end); // O(n)

    // System.out.println("Root Element of Tree: " + preorder[start]  + " start: " + start + " End: " + end
    //                   + " NextGreaterIndex: " + nextGreaterIndex);

    // No next greater Element found node right is null then recur for the left part
    if (nextGreaterIndex == -1) {
      root.right = null;
      root.left = bstFromPreorderUtil(preorder, start + 1, end);
    } else if (nextGreaterIndex == start + 1) {
      root.right = bstFromPreorderUtil(preorder, start + 1, end);
      root.left = null;
    } else {
      root.right = bstFromPreorderUtil(preorder, nextGreaterIndex, end);
      root.left = bstFromPreorderUtil(preorder, start + 1, nextGreaterIndex - 1);
    }

    return root;
  }

  private int findNextGreaterIndex(int[] arr, int start, int end) {
    int target = arr[start];
    int index = -1;

    for (int i = start + 1; i <= end; i++) {
      if (arr[i] >= target) {
        index = i;
        break;
      }
    }

    return index;
  }
}
