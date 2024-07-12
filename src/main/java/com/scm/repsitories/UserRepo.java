package com.scm.repsitories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.OptBoolean;
import com.scm.entities.User;
import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepo extends JpaRepository<User,String>{

    Optional <User> findByEmail(String email);
    Optional <User> findByEmailAndPassword(String email,String password);
}