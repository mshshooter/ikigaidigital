package org.ikigaidigital.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "WITHDRAWALS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Withdrawals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "TIME_DEPOSIT_ID", nullable = false)
    private TimeDeposits timeDeposits;

    @NotNull
    private BigDecimal amount;

    @NotNull
    private Date date;
}
