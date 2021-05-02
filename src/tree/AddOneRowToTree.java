package src.tree;


import java.util.LinkedList;
import java.util.Queue;

class AddOneRowToTree {

    public TreeNode createNewNode(int val) {
        return new TreeNode(val);
    }

    public void addNewRow(TreeNode currNode, int val) {
        TreeNode left = currNode.left;
        TreeNode right = currNode.right;

        // Add the childs
        currNode.left  = createNewNode(val);
        currNode.right = createNewNode(val);

        currNode.left.left = left;
        currNode.right.right = right;
    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {

        // Special cases
        if(depth == 1) {
            TreeNode newNode = createNewNode(val);
            newNode.left = root;
            return newNode;
        }


        int level = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);


        while(!queue.isEmpty()) {
            TreeNode currNode = queue.poll();

            if(currNode == null) {
                level += 1;

                if(!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {

                // if we reach a level above the depth start adding child nodes
                if(level + 1 == depth) {
                    // Add nodes for all row elements
                    while(!queue.isEmpty() && currNode != null) {
                        addNewRow(currNode, val);
                        currNode = queue.poll();
                    }
                    break;
                }


                // Add the left and right child in the queue
                if(currNode.left != null) {
                    queue.add(currNode.left);
                }

                if(currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
        }

        return root;
    }
}