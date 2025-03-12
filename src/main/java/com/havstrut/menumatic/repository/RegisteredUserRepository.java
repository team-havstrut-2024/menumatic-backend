package com.havstrut.menumatic.repository;

import com.havstrut.menumatic.model.RegisteredUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegisteredUserRepository extends JpaRepository<RegisteredUser, Integer> {
    // Select a user with ID
    @Query("SELECT u FROM RegisteredUser u WHERE u.userId = ?1")
    Optional<RegisteredUser> findById(String userId);
}
