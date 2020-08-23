package DS;

public class MyLinkedList {


    static class Node {
        int val;
        Node next;

        Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }

    Node head;

    int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = null;
    }

    private Node getNodeAtIndex(int index){
        if(index >= size){
            return null;
        }
        Node node = head;
        int i=0;
        while(i < index){
            node = node.next;
            i++;
        }
        return node;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node node = getNodeAtIndex(index);
        return node == null ? -1 : node.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        head = new Node(val, head);
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(size == 0) addAtHead(val);
        else{
            Node last = getNodeAtIndex(size-1);
            if(null != last){
                last.next = new Node(val, null);
                size++;
            }
        }
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index>size) return;
        if(index == 0) addAtHead(val);
        else if (index == size) addAtTail(val);
        else{
            Node prev = getNodeAtIndex(index-1);
            if(null != prev){
                Node curr = prev.next;
                prev.next = new Node(val, curr);
                size++;
            }
        }

    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index>=size) return;
        if(index == 0){
            Node prev = head;
            if(null != prev){
                head = prev.next;
            }
        }else{
            Node prev = getNodeAtIndex(index-1);
            if(prev != null){
                Node curr = prev.next;
                prev.next = curr.next;
            }
        }
        size--;
    }

    public int size(){
        return size;
    }

    public static void main(String[] args){
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
