/**
 * @Auther: yza03@mail.ustc.edu.cn
 * @Date: 2022/8/5
 * @Description:
 * @Version: 1.0
 */

public class LinkedListDeque<T> implements Deque<T> {
    private class Node {
        T data;
        Node prev;
        Node next;
        Node() {
            data = null;
            prev = null;
            next = null;
        }
        Node(T in, Node pre, Node nex) {
            data = in;
            prev = pre;
            next = nex;
        }
    }
    private final Node head_node;
    private final Node tail_node;
    private int size;
    LinkedListDeque() {
        size = 0;
        head_node = new Node();
        tail_node = new Node();
    }
    @Override
    public void addFirst(T item) {
        Node newNode = new Node(item, null, null);
        size++;
        if (tail_node.next == null) {
            tail_node.next = newNode;
            head_node.next = newNode;
            newNode.prev = head_node;
        } else {
            newNode.prev = head_node;
            newNode.next = head_node.next;
            head_node.next.prev = newNode;
            head_node.next = newNode;
        }
    }
    @Override
    public void addLast(T item) {
        Node newNode = new Node(item, null, null);
        size++;
        if (tail_node.next == null) {
            tail_node.next = newNode;
            head_node.next = newNode;
            newNode.prev = head_node;
        } else {
            newNode.prev = tail_node.next;
            tail_node.next.next = newNode;
            tail_node.next = newNode;
        }
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public void printDeque() {
        for (Node index = head_node.next; index != null; index = index.next) {
            System.out.print(index.data + " ");
        }
        System.out.println();
    }
    @Override
    public T removeFirst() {
        if (isEmpty()) return null;
        T data = head_node.next.data;
        if (size == 1) {
            head_node.next = null;
            tail_node.next = null;
        } else {
            head_node.next.next.prev = head_node;
            head_node.next = head_node.next.next;
        }
        size--;
        return data;
    }
    @Override
    public T removeLast() {
        if (isEmpty()) return null;
        T data = tail_node.next.data;
        if (size == 1) {
            head_node.next = null;
            tail_node.next = null;
        } else {
            tail_node.next.prev.next = tail_node;
            tail_node.next = tail_node.next.prev;
        }
        size--;
        return data;
    }
    @Override
    public T get(int index) {
        if (index < 0 || index >= size)
            return null;
        Node loop_node = head_node.next;
        for (int i = 0; i < size; i++)
            loop_node = loop_node.next;
        return loop_node.data;
    }
}
