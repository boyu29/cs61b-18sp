/**  Project 1A: Circular ArrayDeque.
 *
 *   ref = "https://sp18.datastructur.es/materials/proj/proj1a/proj1a"
 *
 *   @author: Boyu CHEN 05/04/2021
 *
 * */

public class ArrayDeque<T> {
    private float usage;
    private int size;
    private int nextFirst;
    private int nextLast;
    private T[] Array;

    public ArrayDeque(){
        Array = (T[]) new Object[8];
        size = 0;
        usage = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    private int minusOne(int nextFirst){
        if(nextFirst != 0) nextFirst--;
        else{
            nextFirst = Array.length-1;
        }
        return nextFirst;
    }

    public void addFirst(T item){
        resize();
        Array[nextFirst] = item;
        size++;
        usage = (float) size / (float) Array.length;
        nextFirst = minusOne(nextFirst);
    }

    private int plusOne(int nextLast){
        if( nextLast != Array.length-1) nextLast++;
        else nextLast = 0;
        return nextLast;
    }

    public void addLast(T item){
        resize();
        Array[nextLast] = item;
        size++;
        usage = (float) size / (float) Array.length;
        nextLast = plusOne(nextLast);
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        if( size == 0) System.out.println("Empty AList!");
        else{
            int p = plusOne(nextFirst);
            while(p != nextLast){
                System.out.print(Array[p].toString() + ' ');
                p = plusOne(p);
            }
            System.out.println();
        }
    }

    public T removeFirst(){
        nextFirst = plusOne(nextFirst);
        T firstItem = Array[nextFirst];
        Array[nextFirst] = null;
        size--;
        usage = (float) size / (float) Array.length;
        resize();
        return firstItem;
    }

    public T removeLast(){
        nextLast = minusOne(nextLast);
        T lastItem = Array[nextLast];
        Array[nextLast] = null;
        size--;
        usage = (float) size / (float) Array.length;
        resize();
        return lastItem;
    }

    public T get(int index){
        if(index >= size || index < 0) return null;
        return Array[plusOne(nextFirst+index)];
    }


    private boolean checkUsage(){
        return ( (usage < 0.25) && (Array.length >= 16) );
    }

    private void resize(){
        /** Enlarge the Array when the AList is full. */
        if(size == Array.length){
            T[] copyArray = (T[]) new Object[size*2];
            System.arraycopy(Array, 0, copyArray, 1, size);
            nextFirst = 0;
            nextLast = size+1;
            Array = copyArray;
        }
        /** Shrink the Array when checkUsage is true. */
        else if( checkUsage() ){
            T[] copyArray = (T[]) new Object[Array.length/2];
            if(nextLast > nextFirst){
                System.arraycopy(Array, plusOne(nextFirst), copyArray, 1, nextLast-nextFirst+1);
            }else{
                System.arraycopy(Array, plusOne(nextFirst), copyArray, 1, Array.length-nextFirst-1);
                System.arraycopy(Array, 0, copyArray, Array.length-nextFirst, nextLast);
            }
            nextFirst = 0;
            nextLast = size+1;
            Array = copyArray;
        }
    }

    /** Test resizing method. */

    public void printArray(){
        for (T p : Array) {
            System.out.print(p + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayDeque<String> TestAList = new ArrayDeque<>();
//        TestAList.addLast("aa");
//        TestAList.addLast("bb");
//        TestAList.addFirst("cc");
//        TestAList.addLast("dd");
//        TestAList.addLast("ee");
//        TestAList.addFirst("ff");
//
//        System.out.println("--------------------");
//
//        TestAList.printDeque();
//        System.out.println(TestAList.size());
//        System.out.println(TestAList.get(6));
//
//        System.out.println("--------------------");
//        System.out.println(TestAList.removeFirst());
//        TestAList.printDeque();
//        System.out.println(TestAList.size());
//        System.out.println(TestAList.get(4));
//
//        System.out.println("--------------------");
//        System.out.println(TestAList.removeLast());
//        TestAList.printDeque();
//        System.out.println(TestAList.size());

        TestAList.addLast("aa");
        TestAList.addLast("bb");
        TestAList.addLast("cc");
        TestAList.addLast("dd");
        TestAList.addLast("ee");
        TestAList.addLast("ff");
        TestAList.addLast("gg");
        TestAList.addLast("hh");
        TestAList.addLast("ii");
        TestAList.addLast("jj");
        TestAList.addLast("kk");
        TestAList.addLast("ll");
        TestAList.addLast("mm");
        TestAList.addLast("nn");
        TestAList.addLast("oo");
        TestAList.addLast("pp");
        TestAList.addLast("qq");
        TestAList.addFirst("rr");
        TestAList.addFirst("ss");

        TestAList.printArray();

        TestAList.removeFirst();
        TestAList.removeLast();
        TestAList.removeLast();
        TestAList.removeLast();
        TestAList.removeLast();
        TestAList.removeLast();
        TestAList.removeLast();
        TestAList.removeLast();
        TestAList.removeLast();
        TestAList.removeLast();
        TestAList.removeLast();
        TestAList.removeLast();
        TestAList.removeLast();
        TestAList.removeLast();
        TestAList.removeLast();
        TestAList.removeLast();
        TestAList.removeLast();
        TestAList.removeLast();

        TestAList.printArray();
    }
}
