package org.example;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {
    private StringCalculator cal;

    @Before
    public void setup() {
        cal = new StringCalculator();
    }

    @Test
    public void add_null_or_empty() {
        assertEquals(0, cal.add(null));
        assertEquals(0, cal.add(""));
    }

    @Test
    public void number() {
        assertEquals(10, cal.add("10"));
        assertEquals(3, cal.add("3"));
    }

    @Test
    public void comma() {
        assertEquals(6, cal.add("2,4"));
        assertEquals(10, cal.add("1,2,3,4"));
    }

    @Test
    public void comma_and_colon() {
        assertEquals(4, cal.add("1,2;1"));
        assertEquals(8, cal.add("3;4,1"));
    }

    @Test
    public void custom_token() {
        assertEquals(6, cal.add("//;\n1;2;3"));
    }

    @Test(expected = RuntimeException.class)
    public void testException() {
        cal.add("-1");
    }
}
