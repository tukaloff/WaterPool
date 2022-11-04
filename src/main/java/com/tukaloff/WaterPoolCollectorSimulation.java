package com.tukaloff;

public class WaterPoolCollectorSimulation implements WaterPoolCollector {
    @Override
    public long calculateWaterAmount(int[] landscape) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        int maxPosition = 0;
        for (int i = 0; i < landscape.length; i++) {
            int height = landscape[i];
            if (height < min) min = height;
            if (max < height) {
                max = height;
                maxPosition = i;
            }
        }
        int maxVolume = (max - min) * landscape.length * 2;
        int volume = 0;

        while(maxVolume != 0) {
            maxVolume--;
            landscape[maxPosition]++;
            for (int i = maxPosition-1; i >= 0; i--) {
                landscape[i+1]--;
                landscape[i]++;
                if (isLowland(landscape, i, -1)) {
                    volume++;
                    break;
                }
            }
            maxVolume--;
            landscape[maxPosition]++;
            for (int i = maxPosition+1; i <= landscape.length - 1; i++) {
                landscape[i-1]--;
                landscape[i]++;
                if (isLowland(landscape, i, +1)) {
                    volume++;
                    break;
                }
            }
        }

        return volume;
    }

    private boolean isLowland(int[] landscape, int i, int direction) {
        if (i == 0 || i == landscape.length - 1) {
            landscape[i]--;
            return false;
        }
        if (landscape[i]-1 < landscape[i+direction]) return true;
        return false;
    }
}
