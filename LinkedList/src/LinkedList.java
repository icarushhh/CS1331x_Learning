import java.util.NoSuchElementException;

public class LinkedList<T> implements List {
    // vaiables
    private Node<T> head;
    private Node<T> tail;
    private int size;

    // constructors
    public LinkedList() {
        tail = null;
        head = null;
        size = 0;
    }

    // methods
    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    @Override
    public void addAtIndex(Object data, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Your index is out of the list bounds");
        }
        if (data == null) {
            throw new IllegalArgumentException("You cannot add null data to the list");
        }

        Node<T> curr = head;
        int it = 0;

        if (curr == null) {
            head = new Node<>((T)data);
            tail = head;
        } else if (index == 0) {
            head = new Node<>((T)data, head);
        } else {
            while (curr != null && it < index-1) {
                curr = curr.getNext();
                it++;
            }
            if (curr.getNext() == null) {
                curr.setNext(new Node<>((T)data));
                tail = curr.getNext();
            } else {
                Node<T> temp = curr.getNext();
                curr.setNext(new Node<>((T)data, temp));
            }
        }

        size++;
    }

    @Override
    public Object getAtIndex(int index) {
        if (index < 0 || index > size-1) {
            throw new IllegalArgumentException("Your index is out of the list bounds");
        }

        Node<T> curr = head;
        while (curr.getNext() != null && index-- > 0) {
            curr = curr.getNext();
        }

        return curr.getData();
    }

    @Override
    public Object removeAtIndex(int index) {
        if (index < 0 || index > size-1) {
            throw new IllegalArgumentException("Your index is out of the list bounds");
        }

        Node<T> curr = head;
        Node<T> removed;
        int it = 0;
        if (head == tail) {
            removed = curr;
            head = null;
            tail = null;
        } else if (index == 0) {
            removed = curr;
            head = curr.getNext();
        } else {
            while (curr.getNext() != null && it < index-1) {
                curr = curr.getNext();
                it++;
            }
            removed = curr.getNext();
            if (removed.getNext() == null) {
                tail = curr;
            } else {
                curr.setNext(removed.getNext());
            }
        }

        size--;
        return removed.getData();
    }

    @Override
    public Object remove(Object data) {
        if (data == null) {
            throw new IllegalArgumentException("You cannot remove null data from the list");
        }

        Node<T> curr = head;
        Node<T> removed = null;
        if (curr == null) {
            throw new NoSuchElementException("The data is not present in the list.");
        } else if (head.getData() == data) {
            if (head == tail) {
                tail = null;
            }
            removed = head;
            head = head.getNext();
        } else {
            while (curr.getNext().getNext() != null && curr.getNext().getData() != data) {
                curr = curr.getNext();
            }
            if (curr.getNext().getData() == data) {
                removed = curr.getNext();
                if (curr.getNext().getNext() == null) {
                    tail = curr;
                } else {
                    curr.setNext(removed.getNext());
                }
            }

        }

        if (removed == null) {
            throw new NoSuchElementException("The data is not present in the list.");
        }

        size--;
        return removed.getData();
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    // test code
    public static void main(String[] args) {
        LinkedList<Integer> testLinklist = new LinkedList<>();
        testLinklist.addAtIndex(1, 0);
        testLinklist.addAtIndex(2, 0);
        testLinklist.addAtIndex(3, 0);
        testLinklist.remove(3);
        testLinklist.removeAtIndex(0);

    }
}
