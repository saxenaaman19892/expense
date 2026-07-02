package com.example.expense.repository;

import com.example.expense.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Integer> {

    @Query(value = "select * from transactions where processed = :processed", nativeQuery = true)
    List<Transactions> findAllByProcessed(@Param("processed") int processed);
}
