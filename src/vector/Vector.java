package vector;

import java.util.Arrays;

public class Vector<T> implements SimpleList<T> {
    private T[] itemArray;
    private int size = 0;
    private static final int INITIAL_CAPACITY = 16;

    public Vector() {
        this(INITIAL_CAPACITY);
    }

    public Vector(int initialCapacity) {
        itemArray = (T[]) new Object[initialCapacity];
        this.size = 0;
    }

    public int capacity(){return this.itemArray.length;}

    public void resize(int newCapacity) {
        if(newCapacity > size && newCapacity > itemArray.length){
            T[] temp = (T[]) new Object[newCapacity];
            for(int i = 0; i<itemArray.length; i++){
                temp[i] = itemArray[i];
            }
            itemArray = (T[]) new Object[newCapacity];
            for (int i = 0; i<itemArray.length; i++){
                itemArray[i] = temp[i];
            }
        }else if(newCapacity < itemArray.length && newCapacity > size){
            T[] temp = (T[]) new Object[itemArray.length];
            for(int i = 0; i<temp.length-1; i++){
                temp[i] = itemArray[i];
            }
            itemArray = (T[]) new Object[newCapacity];
            for(int i = 0; i<itemArray.length; i++){
                itemArray[i] = temp[i];
            }
        }
    }

    //helper methods
    private void removeAtHeadHelper(int newCapacity){
        T[] temp = (T[]) new Object[itemArray.length];
        for(int i = 0; i<temp.length-1; i++){
            temp[i] = itemArray[i+1];
        }
        itemArray = (T[]) new Object[newCapacity];
        for(int i = 0; i<itemArray.length; i++){
            itemArray[i] = temp[i];
        }
    }

    private void removeAtTailHelper(int newCapacity){
        T[] temp = (T[]) new Object[itemArray.length];
        for(int i = 0; i<temp.length; i++){
            temp[i] = itemArray[i];
        }
        itemArray = (T[]) new Object[newCapacity];
        for(int i = 0; i<itemArray.length; i++){
            itemArray[i] = temp[i];
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        itemArray = (T[]) new  Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public void insertAtTail(T element) {
        if(size==itemArray.length){
            resize(size +1);
        }
        itemArray[size] = element;
        size++;
    }

    @Override
    public void insertAtHead(T element) {
        if(size==itemArray.length){
            resize(size +1);
        }
        for(int i = size; i>0; i--){
            itemArray[i] = itemArray[i-1];
        }
        size++;
        itemArray[0] = element;
    }

    @Override
    public void insertAt(T element, int index) {
        if (index < size+1) {
            if(size==itemArray.length){
                resize(itemArray.length +1);
            }

            for (int i = size; i > index; i--) {
                itemArray[i] = itemArray[i - 1];
            }
            size++;
            itemArray[index] = element;
        }
    }

    @Override
    public T removeAtTail() {
        if(size>0){
            T item = itemArray[size-1];
            removeAtTailHelper(size-1);
            size--;
            return item;
        }else{
            return itemArray[0];
        }
    }

    @Override
    public T removeAtHead() {
        if(size>0){
            T item = itemArray[0];
            removeAtHeadHelper(size);
            size--;
            return item;
        }else{
            return itemArray[0];
        }
    }

    @Override
    public T removeAt(int index) {
        return null;
    }

    @Override
    public T get(int index) {
        return itemArray[index];
    }

    @Override
    public int find(T element) {
        for(int i = 0; i<size; i++){
            if(itemArray[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
//		return Arrays.toString(this.itemArray); // prints entire array from 0 to capacity-1
        return Arrays.toString(Arrays.copyOfRange(this.itemArray, 0, this.size)); // prints from 0 to size-1
    }
}
