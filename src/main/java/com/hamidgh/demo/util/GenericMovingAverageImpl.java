package com.hamidgh.demo.util;

import java.util.*;

public class GenericMovingAverageImpl<E extends Element> implements MovingAverage<E> {

    private LinkedList<Double> averageList;
    private List<E> elements;
    private int n;

    public GenericMovingAverageImpl(int n) {
        averageList = new LinkedList<>();
        elements = new ArrayList<>();
        this.n = n;
    }

    @Override
    public void add(E e) {
        if (e==null){
            throw new NullPointerException("Input value cannot be null.");
        }
        Double avg;
        if (averageList.size() == 0) {
            avg = e.getValue();
        } else if (averageList.size() < n) {
            avg = ((averageList.size() * averageList.peekLast()) + e.getValue()) / (averageList.size() + 1);
        } else {
            avg = ((n * averageList.peekLast() - this.getElement(this.getSize() - n).getValue()) + e.getValue()) / n;
            averageList.removeFirst();
        }
        averageList.add(avg);
        elements.add(e);
    }

    @Override
    public E getElement(int i) {
        return elements.get(i);
    }

    @Override
    public int getSize() {
        return elements.size();
    }

    @Override
    public Double getMovingAverage() {
        return averageList.peekLast();
    }

    public Double getMovingAverage(int i) {
        return averageList.get(i);
    }
}
