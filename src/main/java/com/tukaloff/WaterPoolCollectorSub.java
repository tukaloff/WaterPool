package com.tukaloff;

public class WaterPoolCollectorSub implements WaterPoolCollector {
    @Override
    public long calculateWaterAmount(int[] landscape) {
        int left = 0, pointer = 1, right = 1,
                pit = 0, bottom = 0, volume = 0, last = landscape.length - 1;
        boolean commit = false;
        while(true) {
            if (right > last) {
                bottom = 0;
                left++;
                right = left+1;
            }
            if (left >= last - 1) break;
            if (landscape[left] > landscape[right]) {
                 if (right < last && landscape[right] < landscape[right + 1]) {
                    bottom += landscape[right++];
                    continue;
                 }
                 if (landscape[right] < landscape[right - 1]) {
                     bottom += landscape[right++];
                     continue;
                 }
                 if (landscape[left + 1] > landscape[right]) {
                     left++;
                     bottom -= landscape[left];
                     continue;
                 }
            }

            pit = Math.min(landscape[left],landscape[right]) * (right - left - 1) - bottom;
            bottom = 0;
            volume += pit;
            left = right;
            right++;
        }
        return volume;
    }
}
