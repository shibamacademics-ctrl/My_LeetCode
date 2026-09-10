import java.util.*;

class LFU {

    // Node represents one cache entry
    class Node {
        int key;
        int value;
        int freq;

        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    // Doubly Linked List for nodes having same frequency
    class DoublyLinkedList {

        Node head;
        Node tail;
        int size;

        DoublyLinkedList() {

            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;

            size = 0;
        }

        // Add node at front
        void addFirst(Node node) {

            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;

            size++;
        }

        // Remove a node
        void remove(Node node) {

            node.prev.next = node.next;
            node.next.prev = node.prev;

            size--;
        }

        // Remove least recently used node
        Node removeLast() {

            if (size == 0) {
                return null;
            }

            Node node = tail.prev;

            remove(node);

            return node;
        }
    }


    private int capacity;
    private int size;
    private int minFreq;

    // key -> Node
    private Map<Integer, Node> keyToNode;

    // frequency -> DoublyLinkedList
    private Map<Integer, DoublyLinkedList> freqToList;


    // Constructor
    public LFU(int capacity) {

        this.capacity = capacity;
        this.size = 0;
        this.minFreq = 0;

        keyToNode = new HashMap<>();
        freqToList = new HashMap<>();
    }


    // Get value
    public int get(int key) {

        if (!keyToNode.containsKey(key)) {
            return -1;
        }

        Node node = keyToNode.get(key);

        increaseFrequency(node);

        return node.value;
    }


    // Put key and value
    public void put(int key, int value) {

        // Capacity is zero
        if (capacity == 0) {
            return;
        }


        // Key already exists
        if (keyToNode.containsKey(key)) {

            Node node = keyToNode.get(key);

            node.value = value;

            increaseFrequency(node);

            return;
        }


        // Cache is full
        if (size == capacity) {

            DoublyLinkedList list = freqToList.get(minFreq);

            Node evicted = list.removeLast();

            keyToNode.remove(evicted.key);

            size--;
        }


        // Create new node
        Node newNode = new Node(key, value);

        keyToNode.put(key, newNode);


        // New node has frequency 1
        freqToList
                .computeIfAbsent(
                        1,
                        k -> new DoublyLinkedList()
                )
                .addFirst(newNode);


        // New node has minimum frequency
        minFreq = 1;

        size++;
    }


    // Increase frequency of node
    private void increaseFrequency(Node node) {

        int oldFreq = node.freq;

        // Get old frequency list
        DoublyLinkedList oldList =
                freqToList.get(oldFreq);


        // Remove from old list
        oldList.remove(node);


        // If old list was minimum frequency
        // and became empty
        if (oldFreq == minFreq &&
                oldList.size == 0) {

            minFreq++;
        }


        // Increase frequency
        node.freq++;


        // Add to new frequency list
        freqToList
                .computeIfAbsent(
                        node.freq,
                        k -> new DoublyLinkedList()
                )
                .addFirst(node);
    }


    // Display cache
    public void display() {

        System.out.println("\nCache:");

        for (Node node : keyToNode.values()) {

            System.out.println(
                    "Key = " + node.key +
                            ", Value = " + node.value +
                            ", Frequency = " + node.freq
            );
        }

        System.out.println(
                "Minimum Frequency = " + minFreq
        );
    }
}


// Main class
public class LFUCache {

    public static void main(String[] args) {

        // Capacity = 2
        LFU cache = new LFU(2);


        System.out.println("put(1, 10)");
        cache.put(1, 10);
        cache.display();


        System.out.println("\nput(2, 20)");
        cache.put(2, 20);
        cache.display();


        System.out.println("\nget(1)");

        System.out.println(
                "Result = " + cache.get(1)
        );

        cache.display();


        System.out.println("\nput(3, 30)");

        cache.put(3, 30);

        cache.display();


        System.out.println("\nget(2)");

        System.out.println(
                "Result = " + cache.get(2)
        );


        System.out.println("\nget(3)");

        System.out.println(
                "Result = " + cache.get(3)
        );


        System.out.println("\nget(1)");

        System.out.println(
                "Result = " + cache.get(1)
        );

        cache.display();
    }
}