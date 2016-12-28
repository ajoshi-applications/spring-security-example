package edu.arturjoshi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by arturjoshi on 28-Dec-16.
 */
@RestController
public class HomeController {
    @RequestMapping(method = RequestMethod.GET, value = "/home")
    public ResponseEntity<?> home() {
        return ResponseEntity.ok("Success");
    }
}
