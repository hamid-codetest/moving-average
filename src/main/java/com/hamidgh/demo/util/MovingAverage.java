package com.hamidgh.demo.util;

public interface MovingAverage<E> {
    /**
     * adds element e to this data Structure.
     * @param e
     */
    void add(E e);

    /**
     * Returns the element at index 0 <= i < {@link #getSize()}. Indexes starts with Zero.
     * @param i
     * @return the element at index i
     */
    E getElement(int i);

    /**
     * Returns the number of elements in this data structure.
     * @return the number of elements in this data structure.
     */
    int getSize();

    /**
     * Returns the moving average of the last N numbers added to this data structure by {@link #add(Object)} method.
     * The value for N might be fixed for either each implementation of this interface or taken as parameter
     * in instance creation. N should be greater than one.
     *
     * The last N Moving Average for a list defined as below:
     * <ol>
     *     <li>if {@link #getSize()} <= N, it will return the avergae of element in the list</li>
     *     <li>if {@link #getSize()} > N, it will return the average of last N elements added to the list.</li>
     * </ol>
     *
     * @return the moving average for the last N elements. .
     */
    Double getMovingAverage();
}
