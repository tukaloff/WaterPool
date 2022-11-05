package com.tukaloff;

public class WaterPoolCollectorN implements WaterPoolCollector {
    @Override
    public long calculateWaterAmount(int[] landscape) {
        int left = 0, right = 1, volume = 0, pit = 0;
        for (int i = 1; i < landscape.length - 1; i++) {
            if (landscape[i] >= landscape[left]) {
                left = i;
                volume += pit;
                pit = 0;
            }
            if (landscape[i] <= landscape[right + 1]) {
                pit += Math.abs((right - left) * (landscape[i + 1] - landscape[i]));
                right = i + 1;
            } else {
                left = i;
                right = i + 1;
                volume += pit;
                pit = 0;
            }
        }
        return volume;
    }
}
