/**
 * Double Ended Queue Array based.
 */
public class ArrayDeque<T> {
    private T[] arr;
    private int size;
    private int nextFirst;
    private int nextLast;

    /**
     * Creates an empty deque.
     */
    public ArrayDeque() {
        arr = (T[]) new Object[8];
        size = 0;
        nextFirst = 7;
        nextLast = 0;
    }

    /**
     * Resizes array.
     *
     * @param size
     * @return
     */
    private T[] resizeArray(int capacity) {
        T[] a = (T[]) new Object[capacity];
        for (int i = 0; i < this.size; i++) {
            nextFirst = (nextFirst + 1) % arr.length;
            a[i] = arr[nextFirst];
        }
        this.nextFirst = capacity - 1;
        this.nextLast = this.size;
        return a;
    }

    /**
     * Adds an item to the array at the next first position.
     *
     * @param item
     */
    public void addFirst(T item) {
        if (arr.length == size) {
            arr = resizeArray(arr.length * 2);
        }
        arr[nextFirst] = item;
        nextFirst = ((nextFirst - 1) + arr.length) % arr.length;
        size++;
    }

    /**
     * Adds an item to the array at the next last position.
     *
     * @param item
     */
    public void addLast(T item) {
        if (arr.length == size) {
            arr = resizeArray(arr.length * 2);
        }
        arr[nextLast] = item;
        nextLast = (nextLast + 1) % arr.length;
        size++;
    }

    /**
     * Returns true if empty.
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * return the size of the deque.
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * Prints out the deque from the front to the back.
     */
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[(nextFirst + i + 1) % arr.length] + " ");
        }
    }

    /**
     * Removes and returns the first item of the deque.
     *
     * @return
     */
    public T removeFirst() {

        T res = arr[(nextFirst + 1) % arr.length];
        if (!isEmpty()) {
            arr[(nextFirst + 1) % arr.length] = null;
            nextFirst = (nextFirst + 1) % arr.length;
            size--;
        }
        if (size < arr.length / 4) {
            arr = resizeArray(arr.length / 2);
        }
        return res;
    }

    /**
     * Removes and returns the last item of the deque.
     *
     * @return
     */
    public T removeLast() {

        T res = arr[((nextLast - 1) + arr.length) % arr.length];
        if (!isEmpty()) {
            arr[((nextLast - 1) + arr.length) % arr.length] = null;
            nextLast = ((nextLast - 1) + arr.length) % arr.length;
            size--;
        }
        if (size < arr.length / 4) {
            arr = resizeArray(arr.length / 2);
        }
        return res;
    }

    /**
     * Gets the item at a given index.
     *
     * @param index
     * @return
     */
    public T get(int index) {
        return arr[(nextFirst + index + 1) % arr.length];
    }


}
