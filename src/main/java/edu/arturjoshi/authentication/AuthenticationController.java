package edu.arturjoshi.authentication;

import edu.arturjoshi.domain.User;
import edu.arturjoshi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

/**
 * Created by arturjoshi on 26-Dec-16.
 */
@RestController
public class AuthenticationController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/securitycontext")
    @ResponseBody
    public Object getContext() {
        SecurityContext ctx = SecurityContextHolder.getContext();
        Authentication authentication = ctx.getAuthentication();
        return authentication == null ? null : authentication.getPrincipal();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public void registerUser(@RequestBody UserRegistrationDto userDto) {
        userRepository.save(new User(userDto));
    }
}
