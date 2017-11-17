package com.t0lia.sparky;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EvaluatorTest {

    @Test
    public void testSum() throws Exception {
        Evaluator evaluator = new Evaluator();
        String result = evaluator.sum("1", "3");
        Assert.assertEquals("4", result);
    }
}