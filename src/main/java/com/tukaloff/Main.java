package com.tukaloff;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] pool = {5,2,3,4,5,4,0,3,1};

        for(int i = 0; i < pool.length / 2; i++) {
            int temp = pool[i];
            pool[i] = pool[pool.length - i - 1];
            pool[pool.length - i - 1] = temp;
        }
        Validator validator = new ValidatorImpl();
        validator.validate(pool);
        WaterPoolCollector collector = new WaterPoolCollectorSimulation();
        long waterAmount = collector.calculateWaterAmount(pool);
        System.out.println(waterAmount);
    }
}