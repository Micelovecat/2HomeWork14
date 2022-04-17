package ru.skypro;

import ru.skypro.exceptions.ElementNotFoundException;
import ru.skypro.exceptions.InputNullException;
import ru.skypro.exceptions.WrongIndexException;

import java.util.Arrays;

public class IntegerListImpl implements List{

    private Integer[] storage;
    private static final int DEFAULT_CAPACITY = 10;
    private int size;

    public IntegerListImpl() {
        this.storage = new Integer[DEFAULT_CAPACITY];
    }

    @Override
    public Integer add(Integer item) {
        checkIfNull(item);

        if (size == storage.length){
            growStorage();
        }

        storage[size++] = item;
        return item;
    }

    private void growStorage() {
        int newCapacity = storage.length * 2;
        storage = Arrays.copyOf(storage, newCapacity);
    }

    private void checkIfNull(Integer item) {
        if (item == null){
            throw new InputNullException("Input parameter is null!");
        }
    }

    @Override
    public Integer add(int index, Integer item) {
        checkIfNull(item);

        if (index < 0 || index > size){
            throw new WrongIndexException("Element index is wrong!");
        }
        if (size == storage.length){
            growStorage();
        }

        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = item;
        size ++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        checkIfNull(item);

        if (index < 0 || index > size){
            throw new WrongIndexException("Element index is wrong!");
        }
        Integer previousElement = storage[index];
        storage[index] = item;
        return previousElement;
    }

    @Override
    public Integer remove(Integer item) {
        checkIfNull(item);
        int removingElementIndex = indexOf(item);

        if (removingElementIndex == -1){
            throw new ElementNotFoundException("Element isn`t found!");
        }
        System.arraycopy(storage, removingElementIndex + 1, storage, removingElementIndex, size - removingElementIndex);
        size --;
        return item;
    }

    @Override
    public Integer remove(int index) {
        if (index < 0 || index > size){
            throw new WrongIndexException("Element index is wrong!");
        }
        Integer removingElement = storage[index];
        System.arraycopy(storage, index + 1, storage, index, size - index);
        size --;
        return removingElement;
    }

    @Override
    public Integer contains(Integer item) {
        checkIfNull(item);

        return null;
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i <= size - 1; i++){
            if (storage[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        return 0;
    }

    @Override
    public Integer get(Integer item) {
        return null;
    }

    @Override
    public boolean equals(IntegerListImpl otherList) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Integer[] toArray() {
        return new Integer[0];
    }
}
