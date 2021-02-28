package ru.demkin.interview.snippets;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ArrayIterator<T> implements Iterator<T> {
  private final T[] array;
  private int position = 0;

  public ArrayIterator(T[] array) {
    Objects.requireNonNull(array, "array must not be null");
    this.array = Arrays.copyOf(array, array.length);
  }

  @Override
  public boolean hasNext() {
    return position < array.length;
  }

  @Override
  public T next() {
    if (!hasNext()) {
      throw new NoSuchElementException(position + " >= " + array.length);
    }
    return array[position++];
  }
}
