package com.t0lia.sparky;

import com.t0lia.sparky.helper.Evaluator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EvaluatorTest {

    @Test
    public void testSumFst() throws Exception {
        Evaluator evaluator = new Evaluator();
        String result = evaluator.sum("6", "3");
        Assert.assertEquals("9", result);
    }
    @Test
    public void testSumSnd() throws Exception {
        Evaluator evaluator = new Evaluator();
        String result = evaluator.sum("1", "3");
        Assert.assertEquals("4", result);
    }
}