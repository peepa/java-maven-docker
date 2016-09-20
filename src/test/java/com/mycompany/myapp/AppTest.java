package com.mycompany.myapp;


import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */

public class AppTest {
    private App sut = new App();
    /**
     * Rigourous Test :-)
     */
    @Test
    public void testApp() {
        Assert.assertTrue(true);
    }

    // adding tests

    @Test
    public void testFailure() throws Exception {
        Assert.assertTrue(false);

    }

    @Test
    public void testCalculate1() throws Exception {

        Assert.assertEquals(2, sut.calculate1(1,1));
    }
}
