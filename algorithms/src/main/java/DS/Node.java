package DS;

import java.util.List;

public class Node {

    public int val;
    public Node next;
    public Node prev;
    public Node child;
    public Node left;
    public Node right;
    public List<Node> children;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}
