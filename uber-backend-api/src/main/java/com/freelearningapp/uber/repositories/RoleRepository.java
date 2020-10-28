package com.freelearningapp.uber.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freelearningapp.uber.models.Role;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findFirstByName(String name);

    // I want a function that gets me the account
    // that account should have a password of xyz

    // CRUD, find-by-attribute, find-by-attribute-of-attribute

}
