package DS;


public class MyHashMap {

    class ListNode{
        int key;
        int val;
        ListNode next;
        ListNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    ListNode[] nodes;

    int size = 10000;

    MyHashMap(){
        nodes = new ListNode[size];
    }

    public int hash(int key){
        return key % size;
    }

    public void put(int key, int value){
        int hash = hash(key);
        if (nodes[hash] == null)
            nodes[hash] = new ListNode(-1, -1);
        ListNode prev = findNode(nodes[hash], key);
        if(prev.next == null){
            prev.next = new ListNode(key, value);
        }else{
            prev.next.val = value;
        }
    }

    private ListNode findNode(ListNode bucket, int key){
        ListNode node = bucket, prev = null;
        while(node != null && node.key != key){
            prev = node;
            node = node.next;
        }
        return prev;
    }

    public int get(int key){
        int hash = hash(key);
        ListNode node = nodes[hash];
        if(node == null) return -1;
        ListNode prev = findNode(node, key);
        return (prev.next != null) ? prev.next.val : -1;
    }

    public void remove(int key){
        int hash = hash(key);
        ListNode node = nodes[hash];
        if(node != null){
            ListNode prev = findNode(node, key);
            if(prev.next != null){
                prev.next = prev.next.next;
            }
        }
    }

    public static void main(String[] args){
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println(hashMap.get(1)); // returns 1
        System.out.println(hashMap.get(3)); // returns -1
        hashMap.put(2, 1);          // update the existing value
        System.out.println(hashMap.get(2)); // returns 1
        hashMap.remove(2);          // remove the mapping for 2
        System.out.println(hashMap.get(2)); // returns -1
    }
}
