import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @BeforeAll
    static void setUpAll(){
        System.out.println("BeforeAll executed");
    }

    @AfterAll
    static void tearAll(){
        System.out.println("AfterAll executed");
    }

    @BeforeEach
    void setUpEach(){
        System.out.println("BeforeEach executed");
    }

    @AfterEach
    void tearEach(){
        System.out.println("AfterEach executed");
    }

    @Test
    void add(){
        int actual = Calculator.add(2,3);
        assertEquals(5,actual);
    }

    @Test
    void testCase1(){
        System.out.println("TC 1 executed");
//        fail("Not implemented yet");
    }

    @Test
    void testCase2(){
        System.out.println("TC 2 executed");
        assertEquals(20,20);
    }

    @Test
    void testCase3(){
        System.out.println("TC 3 executed");
        assertTrue(Calculator.operator.equals("add"));
    }

    @Test
    void testCase4(){
        System.out.println("TC 4 executed");
        assertArrayEquals(new int[]{1,2,3}, new int[]{1,2,3});
    }

    @Test
    void testCase5(){
        System.out.println("TC 5 executed");
        String nullString = null;
        String notNullString = "Testing";

        assertNotNull(notNullString);
        assertNull(nullString);
    }

    @Test
    void testCase6(){
        System.out.println("TC 6 executed");
        Calculator c1 = new Calculator();
        Calculator c2 = c1;
        Calculator c3 = new Calculator();

        assertNotSame(c1,c3);
        assertSame(c1,c2);
    }



}