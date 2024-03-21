package test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class InfiniteTest {
    @Test
    public void testGetMessage() {
        int i = 0;
        while (true) {
            i++;
            System.out.println(i);
        }
    }
}