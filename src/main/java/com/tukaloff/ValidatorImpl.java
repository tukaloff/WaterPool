package com.tukaloff;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ValidatorImpl implements Validator {
    @Override
    public boolean validate(int[] pool) {
        if (pool.length > 32_000) return false;
        long countInvalid = Arrays.stream(pool)
                .filter(i -> i > 32000 || i < 0)
                .count();
        return countInvalid == 0;
    }
}
