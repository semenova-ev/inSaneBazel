package test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import build.Sample;

public class SampleTest {
    @Test
    public void testGetMessage() {
        assertEquals("Hello, world!", Sample.getMessage());
    }
}

