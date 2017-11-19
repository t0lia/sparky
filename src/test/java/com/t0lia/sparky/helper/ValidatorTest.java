package com.t0lia.sparky.helper;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ValidatorTest {
    @DataProvider(name = "Data")
    public static Object[][] Data() {
        return new Object[][]{
                {"123", true},
                {"sfd", false},
        };
    }

    @Test(dataProvider = "Data")
    public void testValidate(String input, boolean expected) throws Exception {
        Validator validator = new Validator();
        boolean actual = validator.validate(input);
        Assert.assertEquals(expected, actual);
    }
}