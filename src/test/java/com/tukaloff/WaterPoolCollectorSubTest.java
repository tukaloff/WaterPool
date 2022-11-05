package com.tukaloff;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaterPoolCollectorSubTest {
    WaterPoolCollector collector = new WaterPoolCollectorSub();
    @Test
    void calculateWaterAmountExample() {
        int[] pool = {5,2,3,4,5,4,0,3,1};
        assertEquals(9, collector.calculateWaterAmount(pool));
    }
    @Test
    void calculateWaterAmountExampleInverse() {
        int[] pool = {5,2,3,4,5,4,0,3,1};

        for(int i = 0; i < pool.length / 2; i++) {
            int temp = pool[i];
            pool[i] = pool[pool.length - i - 1];
            pool[pool.length - i - 1] = temp;
        }
        assertEquals(9, collector.calculateWaterAmount(pool));
    }

    @Test
    void calculateWaterAmountExtended() {
        int[] pool = {5,2,3,4,5,4,0,3,1,1,2};
        assertEquals(11, collector.calculateWaterAmount(pool));
    }

    @Test
    void calculateWaterAmountAnother() {
        int[] pool = {3,1,2,3,2,9,0,2,1};
        assertEquals(6, collector.calculateWaterAmount(pool));
    }

    @Test
    void calculateWaterAmountAnother2() {
        int[] pool = {3,1,3,2,2};
        assertEquals(2, collector.calculateWaterAmount(pool));
    }

    @Test
    void calculateWaterAmountEmpty() {
        int[] emptyPool = {};
        assertEquals(0, collector.calculateWaterAmount(emptyPool));
    }

    @Test
    void calculateWaterAmountOne() {
        int[] emptyPool = {1};
        assertEquals(0, collector.calculateWaterAmount(emptyPool));
    }

    @Test
    void calculateWaterAmountTwo() {
        int[] emptyPool = {1, 2};
        assertEquals(0, collector.calculateWaterAmount(emptyPool));
    }

    @Test
    void calculateWaterAmountThree() {
        int[] emptyPool = {2, 1, 2};
        assertEquals(1, collector.calculateWaterAmount(emptyPool));
    }

    @Test
    void calculateWaterAmountMountain() {
        int[] emptyPool = {2, 3, 2};
        assertEquals(0, collector.calculateWaterAmount(emptyPool));
    }

}