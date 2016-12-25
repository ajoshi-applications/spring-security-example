package edu.arturjoshi.authentication;

import edu.arturjoshi.domain.User;
import edu.arturjoshi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by arturjoshi on 26-Dec-16.
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(s);
        if(user == null) {
            throw new UsernameNotFoundException(s + " user not found");
        }
        return new CustomUserDetails(user);
    }
}
