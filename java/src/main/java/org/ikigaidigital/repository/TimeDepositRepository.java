package org.ikigaidigital.repository;

import java.util.List;

import org.ikigaidigital.entity.TimeDeposits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TimeDepositRepository extends JpaRepository<TimeDeposits, Long> {

    @Query("SELECT DISTINCT td FROM TimeDeposits td LEFT JOIN FETCH td.withdrawals")
    List<TimeDeposits> findAllWithWithdrawals();
}