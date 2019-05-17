package com.wcff.ciocolit.repository;

import com.wcff.ciocolit.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String Username);
}
