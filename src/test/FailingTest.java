package test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import build.Sample;

public class FailingTest {
    @Test
    public void testGetMessage() {
        assertEquals("Justin is the best", Sample.getMessage());
    }
}

