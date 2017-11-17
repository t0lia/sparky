package com.t0lia.sparky;

import static spark.Spark.get;

public class Main {
    private static final String FST = "fst";
    private static final String SND = "snd";

    public static void main(String[] args) {
        get("/hello", (req, res) -> {

            String fst = req.queryParams(FST);
            String snd = req.queryParams(SND);
            Validator validator = new Validator();
            if (validator.validate(fst) && validator.validate(snd)) {
                Evaluator evaluator = new Evaluator();
                return "Sum is: " + evaluator.sum(fst, snd);
            } else {
                return "Params not valid";
            }

        });
    }

}