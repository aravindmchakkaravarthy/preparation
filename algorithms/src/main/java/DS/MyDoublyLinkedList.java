package DS;

public class MyDoublyLinkedList {

    ListNode head;
    ListNode tail;
    int size;

    /**
     * Initialize your data structure here.
     */
    public MyDoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;

    }

    public ListNode getNodeAtIndex(int index) {
        int i =0;
        ListNode node = null;
        while(i<=index && i < size){
            node = head.next;
            i++;
        }
        return node;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        ListNode node = getNodeAtIndex(index);
        return null == node ? -1 : node.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        if(size == 0){
            head = node;
            tail = head;
        }else{
            node.next = head;
            head.prev = node;
            head = node;

        }
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if(size == 0){
            addAtHead(val);
            return;
        }
        ListNode node = new ListNode(val);
        if (size == 1){
            head.next = node;
            node.prev = head;
        }else{
            node.prev = tail;
            tail.next = node;
        }
        tail = node;
        size++;

    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if(index <0 || index > size) return;
        if(index == 0){
            addAtHead(val);
        }else if (index == size){
            addAtTail(val);
        }else {
            ListNode node = getNodeAtIndex(index);
            ListNode newNode = new ListNode(val);
            ListNode prev = node.prev;
            node.prev = newNode;
            newNode.next = node;
            prev.next = newNode;
            size++;
        }

    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if(size == 0) return;
        if(index<0 || index>=size) return;
        ListNode node = getNodeAtIndex(index);
        ListNode prev = node.prev;
        ListNode next = node.next;
        if(prev != null){
            prev.next = next;
        }
        if(next != null){
            next.prev = prev;
        }
    }

    public int size() {
        return size;
    }

    public static void main(String[] args){
        MyDoublyLinkedList ll = new MyDoublyLinkedList();
        ll.addAtHead(1);
        ll.addAtHead(2);
        ll.addAtTail(4);
        ll.addAtTail(3);
        System.out.println(ll.size());
        System.out.println(ll.get(1));
        ll.deleteAtIndex(0);
        System.out.println(ll.get(0));
    }
}
