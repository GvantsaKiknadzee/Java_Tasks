
class Node {
    int key;
    Node prev;
    Node next;

    public Node(int key) {
        this.key = key;
    }
}

public class DeletionDataStructure {
    private Node[] index;
    private Node head;
    private Node tail;

    public DeletionDataStructure(int capacity) {
        index = new Node[capacity];
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
    }

    private int getIndex(int key) {
        return key % index.length;
    }

    public void add(int key) {
        int idx = getIndex(key);
        Node newNode = new Node(key);

        newNode.prev = tail.prev;
        newNode.next = tail;
        tail.prev.next = newNode;
        tail.prev = newNode;

        index[idx] = newNode;
    }

    public void delete(int key) {
        int idx = getIndex(key);
        Node nodeToDelete = index[idx];

        if (nodeToDelete != null && nodeToDelete.key == key) {
            nodeToDelete.prev.next = nodeToDelete.next;
            nodeToDelete.next.prev = nodeToDelete.prev;

            index[idx] = null;
        }
    }

    public void printElements() {
        Node current = head.next;
        while (current != tail) {
            System.out.print(current.key + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DeletionDataStructure ds = new DeletionDataStructure(10);

        ds.add(1);
        ds.add(2);
        ds.add(3);

        System.out.print("Initial elements: ");
        ds.printElements();

        ds.delete(2);

        System.out.print("After deleting 2: ");
        ds.printElements();
    }
}
