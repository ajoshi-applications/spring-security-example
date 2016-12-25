package edu.arturjoshi.repository;

import edu.arturjoshi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

/**
 * Created by arturjoshi on 25-Dec-16.
 */
@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long>{
    User findByEmail(String email);
}
