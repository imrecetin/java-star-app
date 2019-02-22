package com.star;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

public class AppTest extends TestCase {
	private static final String EOL =System.getProperty("line.separator");
    private PrintStream console;
    private ByteArrayOutputStream bytes;
    
    @BeforeEach
    public void setUp() {
       bytes   = new ByteArrayOutputStream();
       console = System.out;
       System.setOut(new PrintStream(bytes));
    }

    @AfterEach
    public void tearDown() {
       System.setOut(console);
    }
    
    @Test
    public void testAbortWhenInsufficientArgumentsSupplied() {
       App.main();
       assertEquals(App.MSG_TOO_FEW_ARGUMENTS + EOL, bytes.toString());
    }

    @Test
    public void testAbortWhenTooManyArgumentsSupplied() {
       App.main("a", "b", "c");
       assertEquals(App.MSG_TOO_MANY_ARGUMENTS + EOL, bytes.toString());
    }
    
    @Test
    public void testSuccessWhenInteger() {
       App.main("5");
       assertEquals(App.MSG_MUST_BE_NUMBER + EOL, bytes.toString());
    }
    
    @Test
    public void testAbortWhenPortNotInteger() {
       App.main("abc");
       assertEquals(App.MSG_MUST_BE_NUMBER + EOL, bytes.toString());
    }

}
