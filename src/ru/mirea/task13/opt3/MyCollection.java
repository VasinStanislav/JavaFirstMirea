package ru.mirea.task13.opt3;

import java.util.Objects;

public class MyCollection<T> {
    private final int INIT_SIZE = 16;
    private final int CUT_RATE = 4;
    transient Object[] array = new Object[INIT_SIZE];
    private int pointer = 0;


    public void add(T item) {
        if(pointer == array.length-1) {
            resize(array.length * 2);
        }
        array[pointer++] = item;
    }

    public T get(int index) {
        Objects.checkIndex(index, pointer);
        return (T) array[index];
    }

    public int indexOf(T item)  {
        for (int i = 0; i<pointer; i++) {
            if (array[i].equals(item))  {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(T item) {
        for (int i = 0; i<pointer; i++) {
            if (array[i].equals(item))  {
                return true;
            }
        }
        return false;
    }

    public void remove(int index) {
        for (int i = index; i<pointer; i++) {
            array[i] = array[i + 1];
        }
        array[pointer] = null;
        pointer--;
        if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE) {
            resize(array.length / 2);
        }
    }

    public int size() {
        return pointer;
    }

    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }

    public void clear()    {
        for (int i = pointer-1; i >= 0; i--)    {
            remove(i);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < pointer; i++) {
            sb.append(array[i] == this ? "(this Collection)" : (T)array[i]);
            if (i == pointer -1)
                return sb.append(']').toString();
            sb.append(',').append(' ');
        }
        return "[]";
    }
}
