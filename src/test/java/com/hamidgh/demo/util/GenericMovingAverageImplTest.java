package com.hamidgh.demo.util;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class GenericMovingAverageImplTest {
    MovingAverage<Score> movingAverage = new GenericMovingAverageImpl<>(3);

    @Test
    public void test_GetAvg_When_Only_One_Element_Exists() {
        Score score = new Score(10);
        movingAverage.add(score);
        Assertions.assertThat(movingAverage.getMovingAverage()).isEqualTo(10);
    }

    @Test
    public void test_GetAvg_When_Elements_Are_Less_Than_Average_Denominator() {

        movingAverage.add(new Score(10));
        movingAverage.add(new Score(20));
        Assertions.assertThat(movingAverage.getMovingAverage()).isEqualTo((10 + 20) / 2.0);
    }

    @Test
    public void test_GetAvg_When_Element_Counts_Are_Equal_To_Average_Denominator() {

        movingAverage.add(new Score(10));
        movingAverage.add(new Score(20));
        movingAverage.add(new Score(30));
        Assertions.assertThat(movingAverage.getMovingAverage()).isEqualTo((10 + 20 + 30) / 3.0);
    }

    @Test
    public void test_GetAvg_When_Element_Counts_Are_Greater_Than_Average_Denominator() {

        movingAverage.add(new Score(10));
        movingAverage.add(new Score(20));
        movingAverage.add(new Score(30));
        movingAverage.add(new Score(40));
        Assertions.assertThat(movingAverage.getMovingAverage()).isEqualTo((20 + 30 + 40) / 3.0);

        movingAverage.add(new Score(40));
        Assertions.assertThat(movingAverage.getMovingAverage()).isEqualTo((40 + 40 + 30) / 3.0);

        movingAverage.add(new Score(50));
        Assertions.assertThat(movingAverage.getMovingAverage()).isEqualTo((50 + 40 + 40) / 3.0);

    }

    class Score implements Element {

        double d;

        public Score(double d) {
            this.d= d;
        }

        @Override
        public Double getValue() {
            return d;
        }
    }
}

