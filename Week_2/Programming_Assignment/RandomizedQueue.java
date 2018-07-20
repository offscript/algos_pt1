import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item>
{
    private int size;
    private Item[] array;
    
    public RandomizedQueue() {
        size = 0;
        array = (Item[]) new Object[2];
    }
    
    public boolean isEmpty()
    {return size == 0;}
    
    public void enqueue(Item item)
    {
        if (size == array.length) resize(2*array.length);
        array[size++] = item; 
    }
    
    public Item dequeue()
    {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        //get a random index in the array
        int random_index = StdRandom.uniform(0,size);
        //swap that spot with the last spot in the array
        Item random_item = array[random_index];
        Item last_item = array[size-1];
        array[random_index] = last_item;
        array[size-1] = null;                              // to avoid loitering
        size--;
        // shrink size of array if necessary
        if (size > 0 && size == array.length/4) resize(array.length/2);
        return random_item;
    }
    
    public Item sample()
    {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        //get a random index in the array
        int random_index = StdRandom.uniform(0,size);
        //get the item in that index
        Item random_item = array[random_index];
        return random_item;
    }
    
    private void resize(int capacity) {
        assert capacity >= size;

        // textbook implementation
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = array[i];
        }
        array = temp;

       // alternative implementation
       // a = java.util.Arrays.copyOf(a, capacity);
    }
    
    public Iterator<Item> iterator()
    {return new RandomArrayIterator();}
    
    private class RandomArrayIterator implements Iterator<Item>
    {
        private int parent_size;
        private Item[] random_array;

        public RandomArrayIterator() {
            parent_size = size;
            System.out.println(parent_size);
            random_array = array;
            System.out.println(random_array);
            StdRandom.shuffle(random_array);
            System.out.println(random_array);
        }
        
        public boolean hasNext() {return parent_size > 0;}
        public void remove() {throw new UnsupportedOperationException();}
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return random_array[--parent_size];
        }
    }
    
    public static void main(String[] args)
    {System.out.println("Why");}

}