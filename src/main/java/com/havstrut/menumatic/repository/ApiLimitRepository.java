package com.havstrut.menumatic.repository;


import java.time.LocalDateTime;
import java.time.OffsetDateTime;


import java.util.Optional;
import com.havstrut.menumatic.model.ApiLimit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApiLimitRepository extends JpaRepository<ApiLimit, Integer> {
    // Select excluded ingredients for mealplan id
    @Query("SELECT al FROM ApiLimit al WHERE al.lastResetTime = ?1")
    Optional<ApiLimit> findByDate(LocalDateTime interval);


}
