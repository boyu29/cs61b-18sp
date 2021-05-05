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

    private int minusOne(int index){
        if(index != 0) index--;
        else{
            index = Array.length-1;
        }
        return index;
    }

    public void addFirst(T item){
        resize();
        Array[nextFirst] = item;
        size++;
        usage = (float) size / (float) Array.length;
        nextFirst = minusOne(nextFirst);
    }

    private int plusOne(int index){
        if( index != Array.length-1) index++;
        else index = 0;
        return index;
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
        if(size == 0) return null;
        T firstItem = Array[plusOne(nextFirst)];
        Array[plusOne(nextFirst)] = null;
        nextFirst = plusOne(nextFirst);
        size--;
        usage = (float) size / (float) Array.length;
        resize();
        return firstItem;
    }

    public T removeLast(){
        if(size == 0) return null;
        T lastItem = Array[minusOne(nextLast)];
        Array[minusOne(nextLast)] = null;
        nextLast = minusOne(nextLast);
        size--;
        usage = (float) size / (float) Array.length;
        resize();
        return lastItem;
    }

    public T get(int index){
        if(index >= size || index < 0) return null;
        return Array[plusOne(nextFirst+index)% Array.length]; //use Array.length as modelo
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

//    public void printArray(){
//        for (T p : Array) {
//            System.out.print(p + " ");
//        }
//        System.out.println();
//    }

//    public static void main(String[] args) {
//        ArrayDeque<Integer> TestAList = new ArrayDeque<>();
//        TestAList.addLast(0);
//        TestAList.addLast(1);
//        TestAList.addLast(2);
//        TestAList.addLast(3);
//        TestAList.addLast(4);
//        TestAList.addLast(5);
//        TestAList.addLast(6);
//        TestAList.addLast(7);
//        TestAList.addLast(8);
//        TestAList.addLast(9);
////        TestAList.addLast(10);
////        TestAList.addLast(11);
////        TestAList.addLast(12);
////        TestAList.addLast(13);
////        TestAList.addLast(14);
////        TestAList.addLast(15);
////        TestAList.addLast(16);
////        TestAList.addLast(17);
//
//        TestAList.printArray();
//        System.out.println(TestAList.get(0));
////        System.out.println(TestAList.get(1));
////        System.out.println(TestAList.get(2));
////        System.out.println(TestAList.get(3));
////        System.out.println(TestAList.get(4));
////        System.out.println(TestAList.get(5));
////        System.out.println(TestAList.get(6));
////        System.out.println(TestAList.get(7));
//
//        int rm = TestAList.removeFirst();
//        System.out.println(rm);
//        TestAList.printArray();
//
//        TestAList.addFirst(rm);
//        TestAList.printArray();
//    }
}
