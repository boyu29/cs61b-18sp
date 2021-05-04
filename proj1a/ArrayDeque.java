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
        Array[nextFirst] = item;
        size++;
        usage = (float) (size / Array.length);
        nextFirst = minusOne(nextFirst);
    }

    private int plusOne(int nextLast){
        if( nextLast != Array.length-1) nextLast++;
        else nextLast = 0;
        return nextLast;
    }

    public void addLast(T item){
        Array[nextLast] = item;
        size++;
        usage = (float) (size / Array.length);
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
        usage = (float) (size / Array.length);
        return firstItem;
    }

    public T removeLast(){
        nextLast = minusOne(nextLast);
        T lastItem = Array[nextLast];
        Array[nextLast] = null;
        size--;
        usage = (float) (size / Array.length);
        return lastItem;
    }

    public T get(int index){
        if(index >= size || index < 0) return null;
        return Array[plusOne(nextFirst+index)];
    }

    public static void main(String[] args) {
        ArrayDeque<String> TestAList = new ArrayDeque<>();
        TestAList.addLast("aa");
        TestAList.addLast("bb");
        TestAList.addFirst("cc");
        TestAList.addLast("dd");
        TestAList.addLast("ee");
        TestAList.addFirst("ff");

        System.out.println("--------------------");

        TestAList.printDeque();
        System.out.println(TestAList.size());
        System.out.println(TestAList.get(6));

        System.out.println("--------------------");
        System.out.println(TestAList.removeFirst());
        TestAList.printDeque();
        System.out.println(TestAList.size());
        System.out.println(TestAList.get(4));

        System.out.println("--------------------");
        System.out.println(TestAList.removeLast());
        TestAList.printDeque();
        System.out.println(TestAList.size());
    }
}
