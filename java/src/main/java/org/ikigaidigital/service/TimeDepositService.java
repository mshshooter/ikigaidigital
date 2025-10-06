package org.ikigaidigital.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.ikigaidigital.TimeDeposit;
import org.ikigaidigital.TimeDepositCalculator;
import org.ikigaidigital.dto.TimeDepositDTO;
import org.ikigaidigital.dto.WithdrawalDTO;
import org.ikigaidigital.entity.TimeDeposits;
import org.ikigaidigital.repository.TimeDepositRepository;
import org.springframework.stereotype.Service;

@Service
public class TimeDepositService {
    private final TimeDepositRepository tdRepository;

    public TimeDepositService(TimeDepositRepository tdRepository) {
        this.tdRepository = tdRepository;
    } 
    
    public void update() {
    	List<TimeDeposits> updatedTds = new ArrayList<TimeDeposits>();
    	List<TimeDeposit> tds = new ArrayList<TimeDeposit>();
    	
       	tdRepository.findAll().forEach(td -> tds.add(new TimeDeposit(td.getId().intValue(), td.getPlanType(), td.getBalance().doubleValue(), td.getDays())));

        new TimeDepositCalculator().updateBalance(tds);
        tds.forEach(td -> {
        	TimeDeposits updatedTd = new TimeDeposits();
        	updatedTd.setId(td.getId());
        	updatedTd.setPlanType(td.getPlanType());
        	updatedTd.setBalance(new BigDecimal(td.getBalance()));
        	updatedTd.setDays(td.getDays());
			updatedTds.add(updatedTd);
		});

        tdRepository.saveAll(updatedTds);
    }
    
    public List<TimeDepositDTO> getAll() {
    	List<TimeDeposits> tds = tdRepository.findAllWithWithdrawals();
        return tds.stream().map(td -> new TimeDepositDTO(
                td.getId(),
                td.getPlanType(),
                td.getBalance().doubleValue(),
                td.getDays(),
                td.getWithdrawals().stream().map(w -> new WithdrawalDTO(w.getId(), w.getAmount().doubleValue(), w.getDate())).toList()
        )).toList();
    }
}
