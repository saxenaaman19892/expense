package com.example.expense.repository;

import com.example.expense.entity.TotalBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TotalBalanceRepository extends JpaRepository<TotalBalance, Integer> {
}
