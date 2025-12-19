class LFUCache {

   class Node {
        int key, value, cnt;
        Node next, prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.cnt = 1;
        }
    }
    class List {
        int size;
        Node head, tail;

        List() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addFront(Node node) {
            Node temp = head.next;
            node.next = temp;
            node.prev = head;
            head.next = node;
            temp.prev = node;
            size++;
        }

        void removeNode(Node node) {
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size--;
        }
    }
    private HashMap<Integer, Node> keyNode;

    private HashMap<Integer, List> freqListMap;

    private int maxSizeCache;
    private int minFreq;
    private int curSize;

    public LFUCache(int capacity) {
        maxSizeCache = capacity;
        minFreq = 0;
        curSize = 0;
        keyNode = new HashMap<>();
        freqListMap = new HashMap<>();
    }

    private void updateFreqListMap(Node node) {

        keyNode.remove(node.key);

        freqListMap.get(node.cnt).removeNode(node);

        if (node.cnt == minFreq &&
            freqListMap.get(node.cnt).size == 0) {
            minFreq++;
        }

        node.cnt++;

        List nextHigherFreqList =
                freqListMap.getOrDefault(node.cnt, new List());

        nextHigherFreqList.addFront(node);

        freqListMap.put(node.cnt, nextHigherFreqList);
        keyNode.put(node.key, node);
    }

    public int get(int key) {
        if (!keyNode.containsKey(key)) {
            return -1;
        }

        Node node = keyNode.get(key);
        int value = node.value;

        updateFreqListMap(node);
        return value;
    }
    public void put(int key, int value) {
        if (maxSizeCache == 0) return;

        if (keyNode.containsKey(key)) {
            Node node = keyNode.get(key);
            node.value = value;
            updateFreqListMap(node);
        } else {

            if (curSize == maxSizeCache) {
                List list = freqListMap.get(minFreq);
                Node nodeToRemove = list.tail.prev;

                keyNode.remove(nodeToRemove.key);
                list.removeNode(nodeToRemove);
                curSize--;
            }

            curSize++;
            minFreq = 1;

            List listFreq =
                    freqListMap.getOrDefault(minFreq, new List());

            Node node = new Node(key, value);
            listFreq.addFront(node);

            keyNode.put(key, node);
            freqListMap.put(minFreq, listFreq);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */