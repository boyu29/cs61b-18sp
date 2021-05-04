/**  Project 1A: Circular Sentinel Linked List Deque.
 *
 *   ref = "https://sp18.datastructur.es/materials/proj/proj1a/proj1a"
 *
 *   @author: Boyu CHEN 05/04/2021
 *
 * */

public class LinkedListDeque<T> {
    private class StuffNode{
        public T item;
        public StuffNode prev;
        public StuffNode next;
        public StuffNode(StuffNode p, T i, StuffNode n){
            prev = p;
            item = i;
            next = n;
        }
    }

    /**  Declare variables. */
    private StuffNode sentinel;
    private int size;

    /**  Create an empty linked list deque. */
    public LinkedListDeque(){
        sentinel = new StuffNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /**  Adds an item of type T to the front of the deque. */
    public void addFirst(T item){
        StuffNode firstItem = new StuffNode(sentinel, item, sentinel.next);
        sentinel.next = firstItem;
        sentinel.next.next.prev = firstItem;
        size += 1;
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item){
        StuffNode lastItem = new StuffNode(sentinel.prev, item, sentinel);
        sentinel.prev.next = lastItem;
        sentinel.prev = lastItem;
        size += 1;
    }

    /**  Returns true if deque is empty, false otherwise. */
    public boolean isEmpty(){
        return (this.size == 0);
    }

    /**  Returns the number of items in the deque. */
    public int size(){
        return this.size;
    }

    /**  Prints the items in the deque from first to last, separated by a space. */
    public void printDeque(){
       StuffNode supportNode = sentinel;
       while(supportNode.next != sentinel){
           System.out.print(supportNode.next.item + " ");
           supportNode = supportNode.next;
       }
    }

    /**  Removes and returns the item at the front of the deque.
     *   If no such item exists, returns null. */
    public T removeFirst(){
        if (size == 0) return null;
        StuffNode RemovedFirstNode = sentinel.next;
        sentinel.next = RemovedFirstNode.next;
        RemovedFirstNode.next.prev = sentinel;
        size -= 1;
        return RemovedFirstNode.item;
    }

    /**  Removes and returns the item at the back of the deque.
     *   If no such item exists, returns null. */
    public T removeLast(){
        if (size == 0) return null;
        StuffNode RemovedLastNode = sentinel.prev;
        sentinel.prev = RemovedLastNode.prev;
        RemovedLastNode.prev.next = sentinel;
        size -= 1;
        return RemovedLastNode.item;
    }

    /**  Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     *   If no such item exists, returns null.
     *   Must not alter the deque! */
    public T get(int index){
        if (size == 0 || index > size-1) return null;
        int counter = 0;
        StuffNode CounterNode = sentinel.next;
        while(counter < index){
            CounterNode = CounterNode.next;
            counter++;
        }
        return CounterNode.item;
    }

    /**  Same as get, but uses recursion. */
    public T getRecursive(int index){
        if (size == 0 || index > size-1 || index < 0) return null;
        StuffNode CounterNode = sentinel.next;
        return getRecursiveHelper(index, CounterNode).item;
    }

    private StuffNode getRecursiveHelper(int index, StuffNode CounterNode){
        if (index == 0) return CounterNode;
        index--;
        return getRecursiveHelper(index, CounterNode.next);
    }

    public static void main(String[] args){
        LinkedListDeque<String> Testlist = new LinkedListDeque<>();
        Testlist.addFirst("1st");
        Testlist.addLast("2nd");
        Testlist.addLast("3rd");
        Testlist.addFirst("addfirst");

        System.out.println("The printDeque method expects '4 1 2 3'.");
        System.out.print("And the method actually returns: ");
        Testlist.printDeque();
        System.out.println();

        System.out.println("The 1st item of the list is: " + Testlist.get(0));
        System.out.println("The 2nd item of the list is: " + Testlist.get(1));
        System.out.println("The 3rd item of the list is: " + Testlist.get(2));
        System.out.println("The 4th item of the list is: " + Testlist.get(3));

        System.out.println("The 1st(recursive) item of the list is: " + Testlist.getRecursive(0));
        System.out.println("The 2nd(recursive) item of the list is: " + Testlist.getRecursive(1));
        System.out.println("The 3rd(recursive) item of the list is: " + Testlist.getRecursive(2));
        System.out.println("The 4th(recursive) item of the list is: " + Testlist.getRecursive(3));

        System.out.println(Testlist.getRecursive(-1));
        System.out.println(Testlist.getRecursive(4));


        System.out.println("The size of Testlist is: " + Testlist.size());

        String RemovedFirstItem = Testlist.removeFirst();
        System.out.print("Remove the first item '" + RemovedFirstItem + "' and we get: ");
        Testlist.printDeque();
        System.out.println();

        String RemovedLastItem = Testlist.removeLast();
        System.out.print("Remove the last item '" + RemovedLastItem + "' and we get: ");

        Testlist.printDeque();
    }
}



















