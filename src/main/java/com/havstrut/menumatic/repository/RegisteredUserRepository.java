package com.havstrut.menumatic.repository;

import com.havstrut.menumatic.model.RegisteredUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegisteredUserRepository extends JpaRepository<RegisteredUser, Integer> {
    /*@Query("SELECT s FROM RegisteredUser s WHERE s.user_id = ?1")
    Optional<RegisteredUser> findRegisteredUserById(int user_id);*/

    @Query("SELECT u FROM RegisteredUser u WHERE u.email = ?1")
    Optional<RegisteredUser> findByEmail(String email);

    @Query("SELECT u FROM RegisteredUser u WHERE u.userId = ?1")
    Optional<RegisteredUser> findById(int userId);
}
