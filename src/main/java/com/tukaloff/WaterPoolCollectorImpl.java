package com.tukaloff;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class WaterPoolCollectorImpl implements WaterPoolCollector {
    @Override
    public long calculateWaterAmount(int[] landscape) {
        int minPosition = getMinPosition(landscape);
        long pit = 0;
        if (landscape.length < 3) return pit;
        int minHeight = landscape[minPosition];
        int left = Math.max(0, minPosition - 1);
        int right = Math.min(landscape.length-1, minPosition + 1);
        while(true) {
            int leftShore = calculateShore(landscape, left, +1);
            int rightShore = calculateShore(landscape, right, -1);
            pit += Math.max(0, (Math.min(leftShore, rightShore) - minHeight)) * (right - left - 1);
            minHeight = Math.max(Math.min(leftShore, rightShore), minHeight);
            if (left == 0 && right == landscape.length - 1) break;
            if (leftShore != -1 && left > 0) left--;
            if (rightShore != -1 && right < landscape.length - 1) right++;
            if (left > 0 && landscape[left-1] < landscape[left]) {
                pit += calculateWaterAmount(Arrays.copyOfRange(landscape, 0, left+1));
                left = 0;
            }
            if (right < landscape.length - 1 && landscape[right+1] < landscape[right]) {
                pit += calculateWaterAmount(Arrays.copyOfRange(landscape, right, landscape.length));
                right = landscape.length-1;
            }
        }
        return pit;
    }

    private int calculateShore(int[] landscape, int position, int direction) {
        int shore = -1;
        if (landscape[position + direction] < landscape[position]) {
            shore = landscape[position];
        }
        return shore;
    }

    private static int getMinPosition(int[] landscape) {
        int min = Integer.MAX_VALUE;
        int minPosition = -1;
        for (int i = 0; i < landscape.length; i++) {
            if (min > landscape[i]) {
                min = landscape[i];
                minPosition = i;
            }
        }
        return minPosition;
    }
}
