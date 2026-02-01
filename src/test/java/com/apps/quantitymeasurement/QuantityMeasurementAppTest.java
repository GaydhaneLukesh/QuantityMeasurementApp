/**
 * @author:LukeshGaydhane
 */

package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class QuantityMeasurementAppTest {

    @Test
    void testMainOutputPass(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        QuantityMeasurementApp.main(new String[]{});
        assertEquals(
                "Welcome to Quantity Measurement App\r\n", outputStream.toString()
        );
    }

    @Test
    void testMainOutputFail(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        QuantityMeasurementApp.main(new String[]{});
        assertNotEquals(
                "Hello World\r\n", outputStream.toString()
        );
    }
}
