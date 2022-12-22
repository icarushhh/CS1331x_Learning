public class Node<T> {
    // variables
    private T data;
    private Node<T> next;

    // constructors
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public Node(T data){
        this(data, null);
    }

    // methods
    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
