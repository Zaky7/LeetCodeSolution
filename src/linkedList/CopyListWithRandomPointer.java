package linkedList;

import java.util.HashMap;

class CopyListWithRandomPointer {

    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    
    private Node createNodePutInMap(Node currentNode, HashMap<Node, Node> valuePtrMap) {
        if(!valuePtrMap.containsKey(currentNode)) {
            Node newNode = new Node(currentNode.val);
            valuePtrMap.put(currentNode, newNode);
            return newNode;
        } else {
            return valuePtrMap.get(currentNode);
        }
    }

    public Node copyRandomList(Node head) {
        // Take a pointer to the head of current linked List  
        if(head == null) {
            return null;
        }
        
        Node current = head;
        HashMap<Node, Node> valuePtrMap = new HashMap<>();
        Node newHeadRef = null;
        Node newTailRef = null;

        while(current != null) {
            Node newNode = createNodePutInMap(current, valuePtrMap);
            
            // Linked the new Node to previous Node
            if(newHeadRef == null) {
                newHeadRef = newNode;
                newTailRef = newNode;
            } else {
                newTailRef.next = newNode;
                newTailRef = newNode;
            }
            
            // Linking the random Pointer in new List
            if(current.random != null) {
                if(valuePtrMap.isEmpty() || !valuePtrMap.containsKey(current.random)) {
                    Node newRandomNode = createNodePutInMap(current.random, valuePtrMap);
                    newTailRef.random = newRandomNode;
                } else {
                    Node oldRandomNode = valuePtrMap.get(current.random);
                    newTailRef.random = oldRandomNode;
                }
            } else {
                newTailRef.random = null;
            }
            current = current.next;
        }
        
        return newHeadRef;
    } 

}