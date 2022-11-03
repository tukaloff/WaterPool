package com.tukaloff;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class ValidatorImplTest {

    Validator validator = new ValidatorImpl();

    @Test
    void validateExample() {
        int[] pool = {5,2,3,4,5,4,0,3,1};
        assertTrue(validator.validate(pool));
    }

    @Test
    void validateEmpty() {
        int[] emptyPool = {};
        assertTrue(validator.validate(emptyPool));
    }

    @Test
    void validateTooLong() {
        int[] tooLongPool = new int[323232];
        assertFalse(validator.validate(tooLongPool));
    }

    @Test
    void validateTooHigh() {
        int[] tooHighPool = {323232, 0, 1, 54};
        assertFalse(validator.validate(tooHighPool));
    }

    @Test
    void validateBelowZero() {
        int[] poolBelowZero = {32, 1, 4, -1, 5, 31000};
        assertFalse(validator.validate(poolBelowZero));
    }

    @Test
    void validateTooHighAndBelowZero() {
        int[] poolTooHighAndBelowZero = {9, 4, -6, 3, 12, -65, 32001};
        assertFalse(validator.validate(poolTooHighAndBelowZero));
    }
}