package com.hamidgh.demo.util;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class IntegerGenericMovingAverageImplTest {

    MovingAverage<Integer> movingAverage = new IntegerMovingAverageImpl(3);

    @Test
    public void test_GetAvg_When_Only_One_Element_Exists() {

        movingAverage.add(10);
        Assertions.assertThat(movingAverage.getMovingAverage()).isEqualTo(10);
    }

    @Test
    public void test_GetAvg_When_Elements_Are_Less_Than_Average_Denominator() {

        movingAverage.add(10);
        movingAverage.add(20);
        Assertions.assertThat(movingAverage.getMovingAverage()).isEqualTo((10 + 20) / 2.0);
    }

    @Test
    public void test_GetAvg_When_Element_Counts_Are_Equal_To_Average_Denominator() {

        movingAverage.add(10);
        movingAverage.add(20);
        movingAverage.add(30);
        Assertions.assertThat(movingAverage.getMovingAverage()).isEqualTo((10 + 20 + 30) / 3.0);
    }

    @Test
    public void test_GetAvg_When_Element_Counts_Are_Greater_Than_Average_Denominator() {

        movingAverage.add(10);
        movingAverage.add(20);
        movingAverage.add(30);
        movingAverage.add(40);
        Assertions.assertThat(movingAverage.getMovingAverage()).isEqualTo((20 + 30 + 40) / 3.0);

        movingAverage.add(40);
        Assertions.assertThat(movingAverage.getMovingAverage()).isEqualTo((40 + 40 + 30) / 3.0);

        movingAverage.add(50);
        Assertions.assertThat(movingAverage.getMovingAverage()).isEqualTo((50 + 40 + 40) / 3.0);

    }
}