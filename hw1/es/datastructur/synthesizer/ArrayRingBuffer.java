package es.datastructur.synthesizer;
import java.util.Iterator;


class ArrayRingBuffer<T> implements BoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;
    /* Index for the next enqueue. */
    private int last;
    /* Variable for the fillCount. */
    private int fillCount;
    /* Variable for the capacity. */
    private int capacity;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    @SuppressWarnings("unchecked")
    public ArrayRingBuffer(int capacity) {
        first = last = fillCount = 0;
        this.capacity = capacity;
        rb = (T[]) new Object[capacity];
    }

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public int fillCount() {
        return fillCount;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow").
     */
    @Override
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update
        //       last. Don't worry about throwing the RuntimeException until you
        //       get to task 4.
        if (isFull()) {throw new RuntimeException("Enqueue to full ring buffer");}
        rb[last] = x;
        last = (last + 1) % capacity;
        fillCount++;
    }

    /**
     * Dequeue the oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    @Override
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and
        //       update first. Don't worry about throwing the RuntimeException until you
        //       get to task 4.
        if (isEmpty()) {throw new RuntimeException("Dequeue a empty ring buffer");}
        fillCount--;
        T item = rb[first];
        first = (first + 1) % capacity;
        return item;
    }

    /**
     * Return oldest item, but don't remove it. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    @Override
    public T peek() {
        // TODO: Return the first item. None of your instance variables should
        //       change. Don't worry about throwing the RuntimeException until you
        //       get to task 4.
        if (isEmpty()) {throw new RuntimeException("Cannot dequeue a empty ring buffer");}
        return rb[first];
    }

    private class RingBufferIterator implements Iterator<T> {
        private int index = first;
        private int itCount = 0;
        @Override
        public boolean hasNext() {
            return itCount < fillCount;
        }

        @Override
        public T next() {
            T item = rb[index];
            index = (index+1)/capacity;
            itCount++;
            return item;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new RingBufferIterator();
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object o) {
        if (o.getClass() == this.getClass()) {
            Iterator<T> itThis = this.iterator();
            Iterator<T> itOther = ((ArrayRingBuffer<T>)o).iterator();
            if (itThis.hasNext() && itOther.hasNext()) {
                if (itThis.next() != itOther.next()) {return false;}
            }
            return !itThis.hasNext() && !itOther.hasNext();
        }
        return false;
    }

    // TODO: When you get to part 4, implement the needed code to support
    //       iteration and equals.
}
    // TODO: Remove all comments that say TODO when you're done.
