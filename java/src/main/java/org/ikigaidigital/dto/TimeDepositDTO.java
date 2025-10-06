package org.ikigaidigital.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TimeDepositDTO {
    private int id;
    private String planType;
    private Double balance;
    private int days;
    private List<WithdrawalDTO> withdrawals;

}
