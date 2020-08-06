package com.example.demo.data;

import com.example.demo.domain.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

// First parameter the entity, second parameter the id
@Repository
public interface JpaUserRepository extends CrudRepository<User, UUID> {
     Optional<User> findByName(String name);
}
