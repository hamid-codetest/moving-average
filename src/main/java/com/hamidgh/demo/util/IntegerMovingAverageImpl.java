package com.hamidgh.demo.util;

import java.util.ArrayList;
import java.util.List;

public class IntegerMovingAverageImpl implements MovingAverage<Integer> {

    private int averageDenom;
    private double average;
    private List<Integer> elements;
    private int n;

    public IntegerMovingAverageImpl(int n) {
        averageDenom = 0;
        average= 0;
        elements = new ArrayList<>();
        this.n = n;
    }

    @Override
    public void add(Integer e) {
        if (e==null){
            throw new NullPointerException("Input value cannot be null.");
        }
        if (averageDenom == 0) {
            average = Double.valueOf(e);
        } else if (averageDenom < n) {
            average = ((averageDenom * average) + e) / (averageDenom + 1);
        } else {
            average = ((n * average - this.getElement(this.getSize() - n)) + e) / n;
        }
        averageDenom++;
        elements.add(e);
    }

    @Override
    public Integer getElement(int i) {
        return elements.get(i);
    }

    @Override
    public int getSize() {
        return elements.size();
    }

    @Override
    public Double getMovingAverage() {
        return average;
    }
}
