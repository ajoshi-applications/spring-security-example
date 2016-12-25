package edu.arturjoshi.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by arturjoshi on 26-Dec-16.
 */
@RestController
public class TestController {
    @RequestMapping(method = RequestMethod.GET, value = "/greeting")
    public String greetings() {
        return "Hello " + SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
