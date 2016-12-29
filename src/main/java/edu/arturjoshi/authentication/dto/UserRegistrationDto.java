package edu.arturjoshi.authentication.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by arturjoshi on 26-Dec-16.
 */
@NoArgsConstructor
@Data
public class UserRegistrationDto {
    private String email;
    private String password;
}
