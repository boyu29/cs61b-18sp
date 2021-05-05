/**  Project 1A: Circular ArrayDeque.
 *
 *   ref = "https://sp18.datastructur.es/materials/proj/proj1a/proj1a"
 *
 *   @author: Boyu CHEN 05/04/2021
 *
 *   dev branch
 *
 * */

//public class ArrayDeque<T> {
//    private float usage;
//    private int size;
//    private int nextFirst;
//    private int nextLast;
//    private T[] Array;
//    private int dev;
//
//    public ArrayDeque(){
//        Array = (T[]) new Object[8];
//        size = 0;
//        usage = 0;
//        nextFirst = 4;
//        nextLast = 5;
//    }
//
//    private int minusOne(int nextFirst){
//        if(nextFirst != 0) nextFirst--;
//        else{
//            nextFirst = Array.length-1;
//        }
//        return nextFirst;
//    }
//
//    public void addFirst(T item){
//        resize();
//        Array[nextFirst] = item;
//        size++;
//        usage = (float) size / (float) Array.length;
//        nextFirst = minusOne(nextFirst);
//    }
//
//    private int plusOne(int nextLast){
//        if( nextLast != Array.length-1) nextLast++;
//        else nextLast = 0;
//        return nextLast;
//    }
//
//    public void addLast(T item){
//        resize();
//        Array[nextLast] = item;
//        size++;
//        usage = (float) size / (float) Array.length;
//        nextLast = plusOne(nextLast);
//    }
//
//    public boolean isEmpty(){
//        return (size == 0);
//    }
//
//    public int size(){
//        return size;
//    }
//
//    public void printDeque(){
//        if( size == 0) System.out.println("Empty AList!");
//        else{
//            int p = plusOne(nextFirst);
//            while(p != nextLast){
//                System.out.print(Array[p].toString() + ' ');
//                p = plusOne(p);
//            }
//            System.out.println();
//        }
//    }
//
//    public T removeFirst(){
//        if(size == 0) return null;
//        nextFirst = plusOne(nextFirst);
//        T firstItem = Array[nextFirst];
//        Array[nextFirst] = null;
//        size--;
//        usage = (float) size / (float) Array.length;
//        resize();
//        return firstItem;
//    }
//
//    public T removeLast(){
//        if(size == 0) return null;
//        nextLast = minusOne(nextLast);
//        T lastItem = Array[nextLast];
//        Array[nextLast] = null;
//        size--;
//        usage = (float) size / (float) Array.length;
//        resize();
//        return lastItem;
//    }
//
//    public T get(int index){
//        if(index >= size || index < 0) return null;
//        return Array[plusOne(nextFirst+index)% Array.length]; //use Array.length as modelo
//    }
//
//
//    private boolean checkUsage(){
//        return ( (usage < 0.25) && (Array.length >= 16) );
//    }
//
//    private void resize(){
//        /** Enlarge the Array when the AList is full. */
//        if(size == Array.length){
//            T[] copyArray = (T[]) new Object[size*2];
//            System.arraycopy(Array, 0, copyArray, 1, size);
//            nextFirst = 0;
//            nextLast = size+1;
//            Array = copyArray;
//        }
//        /** Shrink the Array when checkUsage is true. */
//        else if( checkUsage() ){
//            T[] copyArray = (T[]) new Object[Array.length/2];
//            if(nextLast > nextFirst){
//                System.arraycopy(Array, plusOne(nextFirst), copyArray, 1, nextLast-nextFirst+1);
//            }else{
//                System.arraycopy(Array, plusOne(nextFirst), copyArray, 1, Array.length-nextFirst-1);
//                System.arraycopy(Array, 0, copyArray, Array.length-nextFirst, nextLast);
//            }
//            nextFirst = 0;
//            nextLast = size+1;
//            Array = copyArray;
//        }
//    }
//
//    /** Test resizing method. */
//
//    public void printArray(){
//        for (T p : Array) {
//            System.out.print(p + " ");
//        }
//        System.out.println();
//    }
//
//    public static void main(String[] args) {
//        ArrayDeque<Integer> TestAList = new ArrayDeque<>();
//        TestAList.addLast(0);
//        TestAList.printArray();
//        System.out.println(TestAList.get(0));
//        System.out.println(TestAList.removeFirst());
//        TestAList.printArray();
//
//        TestAList.addLast(3);
//        TestAList.printArray();
//        TestAList.addLast(4);
//        TestAList.addLast(5);
//        TestAList.addFirst(6);
//        TestAList.addLast(7);
//        TestAList.addLast(8);
//        TestAList.addFirst(9);
//        TestAList.addFirst(10);
//        TestAList.addFirst(11);
//
//    }
//}

public class ArrayDeque<T> {

    /**
     * firstPointer is empty space for next first element
     * lastPointer is empty space for next last element
     */
    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;

    /**
     * Construct an empty LinkedListDeque.
     */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = 4;
        nextLast = 5;
        size = 0;
    }

    /**
     * Add item to the front of Deque.
     */
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        size += 1;
        nextFirst = minusOne(nextFirst);
    }

    /**
     * Add item to the end of Deque.
     */
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = item;
        size += 1;
        nextLast = plusOne(nextLast);
    }

    /**
     * Check if LinkedListDeque is empty.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the size of Deque.
     */
    public int size() {
        return size;
    }

    /**
     * Prints LinkedListDeque from first to last.
     */
    public void printDeque() {
        if (size == 0) {
            System.out.println("Empty!");
        } else {
            int m = plusOne(nextFirst);
            while (m != nextLast) {
                System.out.print(items[m].toString() + " ");
                m = plusOne(m);
            }
            System.out.println();
        }
    }

    /**
     * Remove the first item in Deque and return it.
     */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T item = items[plusOne(nextFirst)];
        items[plusOne(nextFirst)] = null;
        nextFirst = plusOne(nextFirst);
        size -= 1;
        if (items.length > 8 && size == items.length / 4) {
            resize(items.length / 2);
        }
        return item;
    }

    /**
     * Remove the last item in Deque and return it.
     */
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T item = items[minusOne(nextLast)];
        items[minusOne(nextLast)] = null;
        nextLast = minusOne(nextLast);
        size -= 1;
        if (items.length > 8 && size == items.length / 4) {
            resize(items.length / 2);
        }

        return item;
    }

    /**
     * Return item at index in Deque in constant time.
     */
    public T get(int index) {
        if (index > size - 1 || index < 0) {
            return null;
        }
        return items[(index + nextFirst + 1) % items.length];
    }

    /* Resize the deque */
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];

        if (nextLast == plusOne(nextFirst)) {
            /* Expand the deque */
            System.arraycopy(items, plusOne(nextFirst), a, 1, items.length - plusOne(nextFirst));
            System.arraycopy(items, 0, a, items.length - plusOne(nextFirst) + 1, nextLast);
            nextFirst = 0;
            nextLast = size + 1;
            items = a;
        } else {
            /* Shrink the deque */
            if (nextFirst > nextLast) {
                System.arraycopy(items, plusOne(nextFirst), a, 1, items.length - nextFirst - 1);
                System.arraycopy(items, 0, a, items.length - nextFirst, nextLast);
            } else {
                /* nextFirst < nextLast */
                System.arraycopy(items, nextFirst + 1, a, 1, size);
            }
            nextFirst = 0;
            nextLast = size + 1;
            items = a;
        }

    }

    /**
     * Helper function to compute index before a given index.
     */
    private int minusOne(int index) {
        if (index == 0) {
            return items.length - 1;
        } else {
            return index - 1;
        }
    }

    /**
     * Helper function to compute index after a given index.
     */
    private int plusOne(int index) {
        if (index == items.length - 1) {
            return 0;
        } else {
            return index + 1;
        }
    }

//    public static void main(String[] args) {
//        ArrayDeque<Integer> de = new ArrayDeque<>();
//        de.addFirst(0);
//        de.get(0);
//        de.addLast(2);
//        de.removeFirst();
//        de.addFirst(4);
//        de.addFirst(5);
//        de.get(1);
//        de.addFirst(7);
//        de.addFirst(8);
//        de.removeFirst();
//        de.get(2);
//        de.get(3);
//        de.addFirst(12);
//        de.addFirst(13);
//        de.addLast(14);
//        int a = de.get(0);
//        de.addLast(16);
//        de.addLast(17);
//        de.addLast(18);
//        de.removeFirst();
//    }

//    public static void main(String[] args) {
//        ArrayDeque<Integer> de = new ArrayDeque<>();
//        de.addFirst(13);
//        de.addFirst(12);
//        de.addFirst(11);
//        de.addFirst(10);
//        de.addFirst(9);
//        de.addFirst(8);
//        de.addFirst(7);
//        de.addFirst(6);
//        de.addFirst(5);
//        de.addFirst(4);
//        de.addFirst(3);
//        de.addFirst(2);
//        de.addFirst(1);
//        de.addFirst(0);
//        de.removeLast();
//        de.removeLast();
//        de.removeLast();
//        de.removeLast();
//        de.removeLast();
//        de.removeLast();
//        de.removeLast();
//        de.removeLast();
//        de.removeLast();
//        de.removeLast();
//        de.removeLast();
//    }
}
