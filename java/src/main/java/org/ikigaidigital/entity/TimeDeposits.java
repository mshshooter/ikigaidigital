package org.ikigaidigital.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TIME_DEPOSITS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TimeDeposits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String planType;

    @NotNull
    private Integer days;

    @NotNull
    private BigDecimal balance;

    @OneToMany(mappedBy = "timeDeposits", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Withdrawals> withdrawals = new ArrayList<>();

}
