package com.loan.repository;

import com.loan.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
  @Query("SELECT COUNT(l) FROM Loan l WHERE l.ip=:ip AND l.issueDate >= :date")
  int countLoansByIpAfterDate(@Param("ip") String ip, @Param("date") LocalDateTime date);
}
