class LRUCache {

    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);

    private int cap;
    private HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    private void addNode(Node newNode) {
        Node temp = head.next;

        newNode.next = temp;
        newNode.prev = head;

        head.next = newNode;
        temp.prev = newNode;
    }
    private void deleteNode(Node delNode) {
        Node prevNode = delNode.prev;
        Node nextNode = delNode.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node resNode = map.get(key);
            int res = resNode.val;

            map.remove(key);
            deleteNode(resNode);
            addNode(resNode);
            map.put(key, head.next);

            return res;
        }
        return -1;
    }

    public void put(int key, int value) {
     
        if (map.containsKey(key)) {
            Node existingNode = map.get(key);
            map.remove(key);
            deleteNode(existingNode);
        }

        if (map.size() == cap) {
            map.remove(tail.prev.key);
            deleteNode(tail.prev);
        }

        Node newNode = new Node(key, value);
        addNode(newNode);
        map.put(key, head.next);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */