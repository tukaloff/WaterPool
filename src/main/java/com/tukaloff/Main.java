package com.tukaloff;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] pool = {3,1,2,3,2,9,0,2,1};
        Validator validator = new ValidatorImpl();
        validator.validate(pool);
        WaterPoolCollector collector = new WaterPoolCollectorImpl();
        long waterAmount = collector.calculateWaterAmount(pool);
        System.out.println(waterAmount);
    }
}