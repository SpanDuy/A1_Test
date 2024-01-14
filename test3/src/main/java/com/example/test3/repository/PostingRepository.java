package com.example.test3.repository;

import com.example.test3.entity.Posting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PostingRepository extends JpaRepository<Posting, Long> {
    List<Posting> findByAuthorizedDelivery(boolean authorizedDelivery);

    @Query(nativeQuery = true,
            value = "SELECT * FROM postings " +
            "WHERE authorized_delivery = :authorizedDelivery AND pstng_date BETWEEN :startDate AND :endDate")
    List<Posting> findByPeriodAndAuthorizedDelivery(@Param("startDate") LocalDate startDate,
                                                    @Param("endDate") LocalDate endDate,
                                                    @Param("authorizedDelivery") Boolean authorizedDelivery);

}