package edu.arturjoshi.authentication;

import edu.arturjoshi.authentication.dto.UserRegistrationDto;
import edu.arturjoshi.authentication.token.TokenHandler;
import edu.arturjoshi.domain.User;
import edu.arturjoshi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

/**
 * Created by arturjoshi on 26-Dec-16.
 */
@RestController
public class AuthenticationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenHandler tokenHandler;

    @Autowired
    private AuthenticationManager authenticationManager;

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

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public String authenticate(@RequestParam String username, @RequestParam String password)
            throws BadCredentialsException {

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        return tokenHandler.createTokenForUser((UserDetails) authentication.getPrincipal());
    }
}
