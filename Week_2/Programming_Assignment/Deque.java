import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item>
{
    private int size;
    private Node<Item> first;
    
    private static class Node<Item> {
       private Item item;
       private Node<Item> next;    
    }
    
    public Deque() {
        first = null;
        int size = 0;
    }
    
    public boolean isEmpty()
    {return size == 0 ? true : false;}
    
    public int size()
    {return size;}
        
    public void addFirst(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        size++; 
    }
    
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }
    
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;
        
        public ListIterator(Node<Item> first) {current = first;}
        
        public boolean hasNext() { return current != null;}
        public void remove() {throw new UnsupportedOperationException();  }
        
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            item = current.item;
            current = current.next;
            return item;
        }
    }
    
    public static void main(String[] args) {
        }
}
    