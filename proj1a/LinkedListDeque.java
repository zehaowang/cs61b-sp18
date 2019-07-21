/**
 * Double ended queue implemented with Linked List.
 *
 * @param <T>
 * @author zehaowang
 */
public class LinkedListDeque<T> {
    private ListNode sentinel;
    private int size;

    /**
     * inner class ListNode.
     */
    private class ListNode {
        private T item;
        private ListNode next;
        private ListNode prev;

        private ListNode(T item, ListNode next, ListNode prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }

        private T getRecursive(int index) {
            if (index == 0) {
                return this.item;
            }
            return next.getRecursive(index - 1);
        }
    }

    /**
     * Creates an empty deque.
     */
    public LinkedListDeque() {
        sentinel = new ListNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /**
     * Constructor with parameter.
     *
     * @param item
     */
    /*public LinkedListDeque(T item) {
        sentinel = new ListNode(null, null, null);
        sentinel.next = new ListNode(item, null, null);
        sentinel.prev = sentinel.next;
        sentinel.next.next = sentinel;
        sentinel.next.prev = sentinel;
        size = 1;
    }*/

    /**
     * adds item to the front of the deque.
     */
    public void addFirst(T item) {
        ListNode newFirst = new ListNode(item, null, null);
        newFirst.next = sentinel.next;
        newFirst.prev = sentinel;
        sentinel.next.prev = newFirst;
        sentinel.next = newFirst;
        size++;
    }

    /**
     * adds item to the back of the deque.
     *
     * @param item
     */
    public void addLast(T item) {
        ListNode newLast = new ListNode(item, null, null);
        newLast.next = sentinel;
        newLast.prev = sentinel.prev;
        sentinel.prev.next = newLast;
        sentinel.prev = newLast;
        size++;
    }

    /**
     * returns true if empty.
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * returns the number of items in the deque.
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * prints the deque from first to last.
     */
    public void printDeque() {
        ListNode p = sentinel.next;
        for (int i = 0; i < size; i++) {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }

    /**
     * removes and returns the item at the front of the deque.
     *
     * @return
     */
    public T removeFirst() {
        T res = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        if (!isEmpty()) {
            size--;
        }
        return res;
    }

    /**
     * removes and returns the item at the back of the deque.
     *
     * @return
     */
    public T removeLast() {
        T res = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        if (!isEmpty()) {
            size--;
        }
        return res;
    }

    /**
     * gets the item at the given index.
     *
     * @param index
     * @return
     */
    public T get(int index) {
        ListNode p = sentinel.next;
        for (int i = 0; i < index && i <= size; i++) {
            p = p.next;
        }
        return p.item;

    }

    /**
     * gets the item at the given index recursive method.
     */
    public T getRecursive(int index) {
        if (size == 0 || index >= size) {
            return null;
        }
        return sentinel.next.getRecursive(index);
    }


}
