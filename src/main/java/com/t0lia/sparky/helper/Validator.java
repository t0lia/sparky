package com.t0lia.sparky.helper;

public class Validator {
    public boolean validate(String fst) {
        try {
            Integer.parseInt(fst);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
