package org.ikigaidigital.controller;

import org.ikigaidigital.service.TimeDepositService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
@RequestMapping("/TimeDesposit")
public class TimeDepositController {

	private final TimeDepositService tdService;

    public TimeDepositController(TimeDepositService tdService) {
        this.tdService = tdService;
    }

    @PostMapping("/update")
	public String update() {
		tdService.update();
		return "Time deposits updated.";
	}

	@GetMapping("/timeDepositListAll")
	public String getAll() {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        return gson.toJson(tdService.getAll());
	}

}
