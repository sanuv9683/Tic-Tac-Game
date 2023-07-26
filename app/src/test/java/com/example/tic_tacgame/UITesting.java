package com.example.tic_tacgame;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class UITesting {

    @Test
    public void testAdd() {
        int a = 2;
        int b = 3;
        int expectedResult = 5;
        int actualResult = a + b;
        assertEquals(expectedResult, actualResult);
    }
}
