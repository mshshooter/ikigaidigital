package org.ikigaidigital.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WithdrawalDTO {
    private int id;
    private Double amount;
    private Date date;

}
