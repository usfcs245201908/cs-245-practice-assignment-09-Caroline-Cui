import java.util.Arrays;

public class BinaryHeap
{
    public int capacity = 11;
    public int heap[];
    public int size = 0;
//  constructor
    public BinaryHeap()
    {
        heap = new int[capacity];
        Arrays.fill(heap, -1);
    }

    public int get(int i)
    {
        return heap[i];
    }

//    swap parent and child
    public void swap(int index1, int index2)
    {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }
//  check if full
    public boolean isFull()
    {
        return size == heap.length;
    }
//  check if empty
    public boolean isEmpty()
    {
        return size == 0;
    }
//    resize the array
    public int[] resize()
    {
        return Arrays.copyOf(heap,heap.length*2);
    }


//    add item
    public void add(int i)
    {
        if (isFull())
        {
            heap = this.resize();
        }
        heap[size++] = i;
        int child = size-1;
        int parent = (child-1)/2;
        while (parent>=0&&
                heap[parent]>heap[child])
        {
            swap(parent,child);
            child=parent;
            parent=(child-1)/2;
        }
    }
//  remove item
    public int remove()
    {
        int temp = heap[0];
        heap[0] = heap[--size];
        siftDown(0);
        return temp;
    }
//    down checking
    public void siftDown(int parent)
    {
        int child = parent*2+1;
        if (child<size&&
                (child+1)<size)
        {
            if (heap[child+1]<heap[child])
            child = child+1;
            if (heap[parent]>heap[child])
            {
                swap(child,parent);
                siftDown(child);
            }
        }
    }
}
