package com.tukaloff;

public class WaterPoolCollectorLinear implements WaterPoolCollector {
    @Override
    public long calculateWaterAmount(int[] landscape) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < landscape.length; i++) {
            int height = landscape[i];
            if (height < min) min = height;
            if (max < height) {
                max = height;
            }
        }
        int volume = 0;

        for (int layer = min; layer <= max; layer++) {
            int pit = 0;
            for (int j = 1; j < landscape.length - 1; j++) {
                int leftShore = landscape[j - 1];
                int local = landscape[j];
                int rigthShore = landscape[j + 1];
                if (local !=  layer) {
                    volume += pit;
                    pit = 0;
                    continue;
                }
                if (leftShore > local) {
                    pit++;
                    landscape[j]++;
                }
                if (local < rigthShore) {
                    volume += pit;
                    pit = 0;
                }
            }
        }

        return volume;
    }
}
