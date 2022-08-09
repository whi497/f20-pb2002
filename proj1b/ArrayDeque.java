/**
 * @Auther: yza03@mail.ustc.edu.com
 * @Date: 2022/8/5
 * @Description:
 * @Version: 1.0
 */

public class ArrayDeque<T> implements Deque<T> {
    private static final int INCREMENT_SIZE = 60;
    private T[] elements;
    private int head;
    private int tail;
    private int size;
    private int capacity;
    ArrayDeque () {
        elements = (T[])new Object[60];
        head = tail = 0;
        size = 0;
        capacity = 60;
    }
    private int move_left(int index) {
        if (index == 0) index = capacity - 1;
        else index--;
        return index;
    }
    private int move_right(int index) {
        if (index == capacity - 1) index = 0;
        else index++;
        return index;
    }
    private boolean isWasted() {
        return size > 16 && capacity/size >= 4;
    }
    private T [] copy_for_resize(){
        T[] newElements = (T[])new Object[capacity + INCREMENT_SIZE];
        int index = head;
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[index];
            index = move_right(index);
        }
        return newElements;
    }
    private void Auto_Increment() {
        if (size == elements.length) {
            elements = copy_for_resize();
            head = 0;
            tail = size - 1;
            capacity += INCREMENT_SIZE;
        }
    }
    private void Auto_Decrement() {
        if(isWasted()) {
            elements = copy_for_resize();
            head = 0;
            tail = size - 1;
            capacity -= INCREMENT_SIZE;
        }
    }
    @Override
    public void addFirst(T item) {
        Auto_Increment();
        if (!isEmpty()) {
            head = move_left(head);
        }
        size++;
        elements[head] = item;
    }
    @Override
    public void addLast(T item) {
        Auto_Increment();
        if (!isEmpty()) {
            tail = move_right(tail);
        }
        size++;
        elements[tail] = item;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public void printDeque() {
        if (!isEmpty()) {
            int index = head;
            for (int i = 0; i < size; i++) {
                System.out.print(elements[index] + " ");
                index = move_right(index);
            }
        }
        System.out.println();
    }
    @Override
    public T removeFirst() {
        if (isEmpty())
            return null;
        Auto_Decrement();
        T item = elements[head];
        if (size != 1) {
            head = move_right(head);
        }
        size--;
        return item;
    }
    @Override
    public T removeLast() {
        if (isEmpty())
            return null;
        Auto_Decrement();
        T item = elements[tail];
        if (size != 1) {
            tail = move_left(tail);
        }
        size--;
        return item;
    }
    @Override
    public T get(int index) {
        if (index<0 || index>=size)
            return null;
        return elements[index + head];
    }
}
