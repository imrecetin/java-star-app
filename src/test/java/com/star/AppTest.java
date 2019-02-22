package com.star;

import static org.junit.Assert.*;
import java.io.*;

import org.junit.*;
import junit.framework.TestCase;

public class AppTest extends TestCase {
	private static final String EOL =System.getProperty("line.separator");
    private PrintStream console;
    private ByteArrayOutputStream bytes;
    
    @Before
    public void setUp() {
       bytes   = new ByteArrayOutputStream();
       console = System.out;
       System.setOut(new PrintStream(bytes));
    }

    @After
    public void tearDown() {
       System.setOut(console);
    }
    
    @Test
    public void testAbortWhenInsufficientArgumentsSupplied() {
       App.main();
       assertEquals(App.MSG_TOO_FEW_ARGUMENTS + EOL + App.USAGE + EOL, bytes.toString());
    }

    @Test
    public void testAbortWhenTooManyArgumentsSupplied() {
       App.main("a", "b", "c");
       assertEquals(App.MSG_TOO_MANY_ARGUMENTS + EOL +App.USAGE + EOL, bytes.toString());
    }
    
    @Test
    public void testAbortWhenPortNotInteger() {
       App.main("abc");
       assertEquals(App.MSG_MUST_BE_NUMBER + EOL + App.USAGE + EOL, bytes.toString());
    }

}
