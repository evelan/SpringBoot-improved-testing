package me.jpomykala.spring.demo.repository;

import me.jpomykala.spring.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Evelan on 23/10/2016.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);
}

