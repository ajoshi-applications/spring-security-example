package edu.arturjoshi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.arturjoshi.authentication.UserRegistrationDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * Created by arturjoshi on 25-Dec-16.
 */
@Entity
@Data
@NoArgsConstructor
public class User {
    @Id @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    @JsonIgnore
    private String password;

    public User(User user) {
        this.id = user.id;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.email = user.email;
        this.password = user.password;
    }

    public User(UserRegistrationDto userDto) {
        this.email = userDto.getEmail();
        this.password = userDto.getPassword();
    }
}
