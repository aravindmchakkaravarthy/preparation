package DS;

/**
 * Design your implementation of the linked list. You can choose to use the singly linked list or the doubly linked list. A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node. If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.
 * <p>
 * Implement these functions in your linked list class:
 * <p>
 * get(index) : Get the value of the index-th node in the linked list. If the index is invalid, return -1.
 * addAtHead(val) : Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
 * addAtTail(val) : Append a node of value val to the last element of the linked list.
 * addAtIndex(index, val) : Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
 * deleteAtIndex(index) : Delete the index-th node in the linked list, if the index is valid.
 * <p>
 * <p>
 * Example:
 * <p>
 * Input:
 * ["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
 * [[],[1],[3],[1,2],[1],[1],[1]]
 * Output:
 * [null,null,null,null,2,null,3]
 * <p>
 * Explanation:
 * MyLinkedList linkedList = new MyLinkedList(); // Initialize empty LinkedList
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
 * linkedList.get(1);            // returns 2
 * linkedList.deleteAtIndex(1);  // now the linked list is 1->3
 * linkedList.get(1);            // returns 3
 */
public class MyLinkedList {

    ListNode head;

    int size;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        head = null;
    }

    private ListNode getNodeAtIndex(int index) {
        if (index >= size) {
            return null;
        }
        ListNode node = head;
        int i = 0;
        while (i < index) {
            node = node.next;
            i++;
        }
        return node;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        ListNode node = getNodeAtIndex(index);
        return node == null ? -1 : node.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        head = new ListNode(val, head);
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if (size == 0) addAtHead(val);
        else {
            ListNode last = getNodeAtIndex(size - 1);
            if (null != last) {
                last.next = new ListNode(val, null);
                size++;
            }
        }
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index == 0) addAtHead(val);
        else if (index == size) addAtTail(val);
        else {
            ListNode prev = getNodeAtIndex(index - 1);
            if (null != prev) {
                ListNode curr = prev.next;
                prev.next = new ListNode(val, curr);
                size++;
            }
        }

    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index >= size) return;
        if (index == 0) {
            ListNode prev = head;
            if (null != prev) {
                head = prev.next;
            }
        } else {
            ListNode prev = getNodeAtIndex(index - 1);
            if (prev != null) {
                ListNode curr = prev.next;
                prev.next = curr.next;
            }
        }
        size--;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList();
        ll.addAtHead(1);
        ll.addAtTail(3);
        ll.addAtIndex(1, 2);
        System.out.println(ll.size());
        System.out.println(ll.get(1));
        ll.deleteAtIndex(0);
        System.out.println(ll.get(0));
    }
}
