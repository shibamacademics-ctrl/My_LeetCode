class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    MinHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }
    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full");
            return;
        }

        heap[size] = value;
        int current = size;
        size++;

        while (current > 0 && heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public int extractMin() {
        if (size == 0) {
            throw new RuntimeException("Heap is empty");
        }

        int min = heap[0];

        heap[0] = heap[size - 1];
        size--;

        heapifyDown(0);

        return min;
    }

    private void heapifyDown(int index) {
        int smallest = index;

        int left = leftChild(index);
        int right = rightChild(index);

        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }

        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}

class ImplmentationOfHeap {
    public static void main(String[] args) {
        MinHeap h = new MinHeap(10);

        h.insert(20);
        h.insert(5);
        h.insert(15);
        h.insert(2);
        h.insert(10);

        h.display();

        System.out.println("Minimum: " + h.extractMin());

        h.display();
    }
}