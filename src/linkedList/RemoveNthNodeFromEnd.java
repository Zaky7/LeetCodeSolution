package linkedList;

class RemoveNthNodeFromEnd {

     private class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }


    public ListNode removeNthFromEnd(ListNode head, int k) {
        
        
        if(head == null) {
            return head;
        }
        
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        ListNode prevSlowPtr = null;
        
        // Move the fast Pointer by K positions
        while(k != 0) {
            fastPtr = fastPtr.next;
            k--;
        }
        
        // System.out.println(head + " K: " + k);

        
        // Move the slowPtr until fast pointer points to null
        while(fastPtr != null) {
            prevSlowPtr = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }
        
        
        // fisrt element to be removed
        if(prevSlowPtr == null) {
            head = head.next;
        } else {
            prevSlowPtr.next = slowPtr.next;
        }
        
        return head;
    }
}