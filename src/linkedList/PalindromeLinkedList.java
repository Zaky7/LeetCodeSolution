package linkedList;

class PallindromeLinkedList {

  private class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }

    ListNode prev = null;
    ListNode curr = head;
    ListNode next = head.next;
    ListNode fast = head;
    boolean isEven = fast.next != null;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      curr.next = prev;
      prev = curr;
      curr = next;
      next = next.next;
    }

    isEven = fast == null;
    ListNode ptr1 = prev;
    ListNode ptr2 = isEven ? curr : next;

    while (ptr1 != null && ptr2 != null) {
      if (ptr1.val != ptr2.val) {
        return false;
      }

      ptr1 = ptr1.next;
      ptr2 = ptr2.next;
    }

    if ((ptr1 == null && ptr2 != null) || (ptr1 != null && ptr2 == null)) {
      return false;
    } else {
      return true;
    }
  }
}
