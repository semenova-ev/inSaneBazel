package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SampleTest {
    @Test
    public void testGetMessage() {
        assertEquals("Hello, world!", Sample.getMessage());
    }
}

