package refactoring.methodextraction;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;

import static org.junit.jupiter.api.Assertions.*;

class MethodExtractionTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    void testPrintOwing() {
        Enumeration<Order> orders = Collections.enumeration(Arrays.asList(
                new Order(10.0),
                new Order(20.0)
        ));
        MethodExtraction sut = new MethodExtraction(orders, "bob");

        sut.printOwing();
        String expected =
            "*******************\n" +
            "** Customer Owns **\n" +
            "*******************\n" +
            "name:bob\n" +
            "amount:30.0\n";
        assertEquals(expected, outContent.toString());
    }


    @AfterEach
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
}