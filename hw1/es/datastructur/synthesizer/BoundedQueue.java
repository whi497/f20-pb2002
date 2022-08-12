/**
 * @Auther: yza03@mail.ustc.edu.cn
 * @Date: 2022/8/11
 * @Description:
 * @Version: 1.0
 */
package es.datastructur.synthesizer;

interface BoundedQueue<Type> extends Iterable<Type> {
    /*returns the capacity of the queue*/
    int capacity();
    /*returns the number of items currently in the buffer*/
    int fillCount();
    /*add elem to the end of the queue*/
    void enqueue(Type elem);
    /*delete the element form the front and return it*/
    Type dequeue();
    /*return the element at the front of the queue*/
    Type peek();
    /*check if the queue is empty or full*/
    default boolean isEmpty() {return fillCount() == 0;}
    default boolean isFull() {return capacity() == fillCount();}
}
