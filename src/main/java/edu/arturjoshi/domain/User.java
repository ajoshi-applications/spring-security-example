package edu.arturjoshi.domain;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * Created by arturjoshi on 25-Dec-16.
 */
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class User {
    @Id @GeneratedValue
    private Long id;
    private @NonNull String username;
    @Transient
    private @NonNull String password;
}
