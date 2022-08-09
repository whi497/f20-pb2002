/**
 * @Auther: yza03@mail.ustc.edu.cn
 * @Date: 2022/8/7
 * @Description:
 * @Version: 1.0
 */

public interface Deque<T> {
    void addFirst(T item);

    void addLast(T item);

    default boolean isEmpty() {
        return size() == 0;
    }

    int size();

    void printDeque();

    T removeFirst();

    T removeLast();

    T get(int index);
}
