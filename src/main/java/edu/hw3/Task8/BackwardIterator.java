package edu.hw3.Task8;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class BackwardIterator<T extends Object> implements Iterator<T>{
    private int currentIndex;
    private final List<T> list;
    public BackwardIterator(List<T> list)
    {
        this.list = list;
        currentIndex = list.size() - 1;
    }

    @Override
    public boolean hasNext() {
        if(currentIndex >= 0)
        {
            return true;
        }
        currentIndex--;
        return false;
    }

    @Override
    public T next() {
        if(!hasNext())
        {
            throw new NoSuchElementException();
        }
        return list.get(currentIndex--);
    }
}
