package com.itemis.salestaxes;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Mouad Douieb
 */
public class ReceiptTest {
    
    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    
    public ReceiptTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
                System.out.println(getClass().getClassLoader().getResource("input1.txt").getPath());

    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of processOrder method, of class Receipt.
     */
    @Test
    public void testInput1() {
        Receipt receipt = new Receipt();
        receipt.setFilename("./src/test/java/com/itemis/salestaxes/input1.txt");
        receipt.startOrder();
        String expectedOutput = Utils.readOutputFile("./src/test/java/com/itemis/salestaxes/output1.txt");
        assertEquals(expectedOutput, receipt.toString());
    }
    
    /**
     * Test of processOrder method, of class Receipt.
     */
    @Test
    public void testInput2() {
        Receipt receipt = new Receipt();
        receipt.setFilename("./src/test/java/com/itemis/salestaxes/input2.txt");
        receipt.startOrder();
        String expectedOutput = Utils.readOutputFile("./src/test/java/com/itemis/salestaxes/output2.txt");
        assertEquals(expectedOutput, receipt.toString());
    }
    
    /**
     * Test of processOrder method, of class Receipt.
     */
    @Test
    public void testInput3() {
        Receipt receipt = new Receipt();
        receipt.setFilename("./src/test/java/com/itemis/salestaxes/input3.txt");
        receipt.startOrder();
        String expectedOutput = Utils.readOutputFile("./src/test/java/com/itemis/salestaxes/output3.txt");
        assertEquals(expectedOutput, receipt.toString());
    }
    
}
