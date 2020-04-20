public class ArrayDeque<T> {
    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;

    /** Creates an empty list. */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0 ? true : false);
    }

    private int minusOne(int x) {
        return Math.floorMod(x-1, items.length);
    }

    private int plusOne(int x) {
        return Math.floorMod(x+1, items.length);
    }

    private int plusOne(int x, int length) {
        return Math.floorMod(x+1, length);

    }

    /** Resizes the underlying array to the target capacity. */
    private void resize() {
        if (items.length == size) {
            resizeHelper(items.length*2);
        } else if (4 * size < items.length && items.length > 8) {
            resizeHelper(items.length/2);
        }
    }

    private void resizeHelper(int capacity) {
        T[] temp = items;
        int begin = plusOne(nextFirst);
        int end = minusOne(nextLast);
        items = (T[]) new Object[capacity];
        nextFirst = 0;
        nextLast = 1;
        for (int i = begin; i != end; i = plusOne(i, temp.length)) {
            items[nextLast] = temp[i];
            nextLast += 1;
        }
        items[nextLast] = temp[end];
        nextLast += 1;
    }



    public void addFirst(T x) {
        resize();
        items[nextFirst] = x;
        nextFirst = minusOne(nextFirst);
        size++;
    }

    /** Inserts X into the back of the list. */
    public void addLast(T x) {
        resize();

        items[nextLast] = x;
        nextLast = plusOne(nextLast);
        size = size + 1;
    }

    private T getFirst() {
        return items[plusOne(nextFirst)];
    }

    public T removeFirst() {
        resize();
        T result = getFirst();
        nextFirst = plusOne(nextFirst);
        items[nextFirst] = null;
        size--;
        return result;

    }

    private T getLast() {
        return items[minusOne(nextLast)];
    }

    public T removeLast() {
        resize();
        T result = getLast();
        nextLast = minusOne(nextLast);
        items[nextLast] = null;
        size--;
        return result;

    }

    public T get(int i) {
        if (i < 0 || i >= size) {
            return null;
        }
        i = Math.floorMod(plusOne(nextFirst) + i, items.length);
        return items[i];
    }

    public void printDeque() {
        for (int index = plusOne(nextFirst); index != nextLast; index = plusOne(index)) {
            System.out.print(items[index]);
            System.out.print(" ");
        }
        System.out.println();
    }


//    public static void main(String[] args) {
//        ArrayDeque<Integer> a = new ArrayDeque<Integer>();
//        for (int i = 0; i < 20; i++) {
//            a.addLast(i);
//        }
//        a.printDeque();
//
//        for (int i = 0; i < 15; i++) {
//            a.removeFirst();
//        }
//
//        a.printDeque();
//        System.out.println(a.get(1));
//    }

}
