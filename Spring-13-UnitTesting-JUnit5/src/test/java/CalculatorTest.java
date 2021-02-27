import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void add(){
        int actual = Calculator.add(2,3);
        assertEquals(5,actual);
    }

    @Test
    void testCase1(){
//        fail("Not implemented yet");
    }

    @Test
    void testCase2(){
        assertEquals(20,20);
    }

    @Test
    void testCase3(){
       assertTrue(Calculator.operator.equals("add"));
    }

    @Test
    void testCase4(){
        assertArrayEquals(new int[]{1,2,3}, new int[]{1,2,3});
    }

    @Test
    void testCase5(){
        String nullString = null;
        String notNullString = "Testing";

        assertNotNull(notNullString);
        assertNull(nullString);
    }

    @Test
    void testCase6(){
        Calculator c1 = new Calculator();
        Calculator c2 = c1;
        Calculator c3 = new Calculator();

        assertNotSame(c1,c3);
        assertSame(c1,c2);
    }


}