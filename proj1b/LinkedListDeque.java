public class LinkedListDeque <T> implements Deque<T> {
    private class IntNode {
        public T item;
        public IntNode next;
        public IntNode prev;

        public IntNode(T i, IntNode n, IntNode p) {
            item = i;
            next = n;
            prev = p;
        }
    }

    private IntNode sentinel;
    private int size;

    /** create a empty SLlist. */
    public LinkedListDeque() {
        sentinel = new IntNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }


    public void addFirst(T x) {
        // sentinel.next = new IntNode(x, sentinel.next, sentinel);
        // sentinel.next.next.prev = sentinel.next;
        IntNode newnode = new IntNode(x, null, null);
        IntNode temp = sentinel.next;
        sentinel.next = newnode;
        newnode.prev = sentinel;
        newnode.next = temp;
        temp.prev = newnode;
        size += 1;
    }


    public void addLast(T x) {
        // sentinel.prev.next = new IntNode(x, sentinel.prev, sentinel);
        // sentinel.prev = sentinel.prev.next;
        IntNode newnode = new IntNode(x, null, null);
        IntNode temp = sentinel.prev;
        sentinel.prev = newnode;
        newnode.prev = temp;
        newnode.next = sentinel;
        temp.next = newnode;
        size += 1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (this.size == 0);
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T x = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;

        return x;

    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T x = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;

        return x;

    }

    public void printDeque() {
        IntNode current = sentinel;
        while (current.next != sentinel){
            System.out.print(current.next.item + " ");
            current = current.next;

        }

    }

    public T get(int index) {
        int length = size;
        IntNode target = sentinel.next;
        if (index > length - 1) {
            return null;
        } else {
            for (int i=0; i<index; i++) {
                target = target.next;
            }
        }
        return target.item;
    }

    public T getRecursive(int index) {
        int length = size;
        if (index > length - 1) {
            return null;
        } else {
            return traverse(sentinel.next, index);
        }

    }

    private T traverse(IntNode n,int i) {
        if (i == 0) {
            return n.item;
        } else {
            return traverse(n.next, i - 1);
        }
    }


//    public static void main(String[] args) {
//        LinkedListDeque<Integer> L = new LinkedListDeque<>();
//        L.addFirst(10);
//        L.addFirst(5);
//        L.addLast(13);
//        L.addLast(18);
//        L.removeFirst();
//        System.out.println(L.removeLast());
////        System.out.println(L.get(2));
//
//    }
}

