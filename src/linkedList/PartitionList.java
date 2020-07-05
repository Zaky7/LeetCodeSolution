package linkedList;

public class PartitionList {

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode partitionWithoutDummy(ListNode head, int x) {
        ListNode smallHead = null;
        ListNode small = null;
        ListNode prev = null;
        ListNode curr = head;
        ListNode largeHead = null;
            
        while(curr != null) {
            if(curr.val < x) {                
                // For first node less than x
                if(smallHead == null) {
                    smallHead = curr;
                    small = smallHead;

                    // unlink the previous node
                    if(prev != null) {
                        prev.next = curr.next;
                    } else {
                        prev = curr;
                    }
                    
                   
                    curr = curr.next;

                    // separate the new node from the rest of the list
                    small.next = null;
                } else {
                    small.next = curr;
                    
                    // For the subsequent node
                    if(prev != small) {
                        // 1. Unlink the smaller Node from in between
                        curr = curr.next;
                        prev.next = curr;

                        // 2. Move the smaller pointer
                        small = small.next;
                        small.next = null;
                    } else {
                        small = small.next;
                        prev = curr;
                        curr = curr.next;
                    }
                }
            } else { 
                if(largeHead == null) {
                    largeHead = curr;
                }

                prev = curr;
                curr = curr.next;
            }
        }

         
        if(small != null) {
            small.next = largeHead;
            return smallHead;    
        } else {
            return head;
        }
        
    }

    public ListNode partition(ListNode head, int x) {
        
        // point them to the dummy node
        ListNode beforeHead = new ListNode(0);
        ListNode afterHead  = new ListNode(0);
        
        
        ListNode before = beforeHead;
        ListNode after  = afterHead;
        ListNode curr = head;
        
        
        while(curr != null) {
            if(curr.val < x) {
                // point to smaller node and make next pointer null
                // also move the curr node
                before.next = curr;
                curr = curr.next;
                before = before.next;
                before.next = null;
            } else {
                after.next = curr;
                curr = curr.next;
                after = after.next;
                after.next = null;
            }
        }
        
        
        // each element either smaller than x or larger than x, no lists would be created
        if(before == beforeHead || after == afterHead) {
            return head;
        } else {
            ListNode prev = beforeHead;
            beforeHead = beforeHead.next;
            prev.next = null;
            
            prev = afterHead;
            afterHead = afterHead.next;
            prev.next = null;
            
            before.next = afterHead;
            return beforeHead;
        }
    }

    public static void main(String[] args) {

    }
}