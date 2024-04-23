/*package com.havstrut.menumatic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegisteredUserRepositoryFromDemo extends JpaRepository<RegisteredUserFromDemo, Integer> {
    @Query("SELECT s FROM Student s WHERE s.user_id = ?1")
    Optional<RegisteredUserFromDemo> findRegisteredUserById(int user_id);
}
*/