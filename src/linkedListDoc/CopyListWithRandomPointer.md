# Copy List 🔗 With Random Pointer ➡️

A linked list is given such that each node contains an additional **random pointer** which could point to any node in the list or null.

Return a deep copy of the list.

Input <br/>
**val**: an integer representing `Node.val` <br/>
**random_index**: the index of the node (range from 0 to n-1) or null

For e.g

```
Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
```

### Pseudocode:-

Since we need to return a **deep copy** 😬 of the List 🔗 i.e. We need to copy list as well as random ptr.

- You will notice if problem is about deep copying a linked list then the problem would be _trivial_. Then we need iterate over a list and create a **new List** side by side, but since we have random pointer pointing to a Node in the list or null then need to do something else.

- We would create a **hash map** of node having key as node in original list and its corresponding node in copied list.
- Whenever we create a new node in the new list we check if entry present in the map then we return it otherwise we create new node and put its entry in the map.

```java
private Node createNodePutInMap(Node currentNode, HashMap<Node, Node> valuePtrMap) {
       if(!valuePtrMap.containsKey(currentNode)) {
           Node newNode = new Node(currentNode.val);
           valuePtrMap.put(currentNode, newNode);
           return newNode;
       } else {
           return valuePtrMap.get(currentNode);
       }
   }
```

- Create two ptr for new List one pointing to the **head** other pointing to the **tail**. We also create a ptr pointing to the head of original list.

```java
    Node current = head;
    HashMap<Node, Node> valuePtrMap = new HashMap<>();
    Node newHeadRef = null;
    Node newTailRef = null;
```

- Now iterate over the list and create new node or get the existing node using `createNodePutInMap` function

- For first time point newly created node to the head and tail then for subsequent nodes link the tail of copied list to the new node created.

```java
    if(newHeadRef == null) {
        newHeadRef = newNode;
        newTailRef = newNode;
    } else {
        newTailRef.next = newNode;
        newTailRef = newNode;
    }
```

- Also check if the original node `random ptr` is already created then point it the newly create node to it otherwise create newNode and add its entry in the map.

```java
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
```

- Repeat by moving current node to the next node

```java
   current = current.next;
```
