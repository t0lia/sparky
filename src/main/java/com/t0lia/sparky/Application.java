package com.t0lia.sparky;

import com.t0lia.sparky.helper.Evaluator;
import com.t0lia.sparky.helper.Validator;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;

public class Application {
    private static final String FST = "fst";
    private static final String SND = "snd";

    private FreeMarkerEngine freeMarkerEngine;

    public Application() {
        freeMarkerEngine = new FreeMarkerEngine();
        Configuration freeMarkerConfiguration = new Configuration();
        freeMarkerConfiguration.setTemplateLoader(new ClassTemplateLoader(Application.class, "/"));
        freeMarkerEngine.setConfiguration(freeMarkerConfiguration);
    }

    public void start() {
        get("/", this::index);
        get("/eval", this::eval);
        get("/about", this::about);
    }

    private String index(Request req, Response res) {
        res.status(200);
        res.type("text/html");
        Map<String, Object> attributes = new HashMap<>();
        return freeMarkerEngine.render(new ModelAndView(attributes, "pages/index.ftl"));
    }

    private String eval(Request req, Response res) {
        String fst = req.queryParams(FST);
        String snd = req.queryParams(SND);
        Validator validator = new Validator();
        String result;
        if (validator.validate(fst) && validator.validate(snd)) {
            Evaluator evaluator = new Evaluator();
            result = "Sum is: " + evaluator.sum(fst, snd);
        } else {
            result = "Params not valid";
        }

        Map<String, Object> attributes = new HashMap<>();
        attributes.put("result", result);
        return freeMarkerEngine.render(new ModelAndView(attributes, "pages/eval.ftl"));
    }

    private String about(Request req, Response res) {
        res.status(200);
        res.type("text/html");
        Map<String, Object> attributes = new HashMap<>();
        return freeMarkerEngine.render(new ModelAndView(attributes, "pages/about.ftl"));
    }
}
