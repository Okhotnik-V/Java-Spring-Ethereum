package com.okhotnik.demosolidity.controllers;

import com.okhotnik.demosolidity.Services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContractController {

    @Autowired
    ContractService contractService;

    @GetMapping("/contract/deploy")
    public String contractDeploy() throws Exception {
        return contractService.deployContract();
    }

    @GetMapping("/contract/load")
    public String contractLoad() throws Exception {
        return contractService.loadContract().getContractAddress();
    }

    @GetMapping("/contract/get")
    public String getHello() throws Exception {
        return contractService.getHello();
    }

    @GetMapping("/contract/set")
    public String setHello(@RequestParam String text) throws Exception {
        return contractService.setHello(text);
    }
}
