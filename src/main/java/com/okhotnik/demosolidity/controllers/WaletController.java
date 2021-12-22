package com.okhotnik.demosolidity.controllers;

import com.okhotnik.demosolidity.Services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WaletController {

    @Autowired
    WalletService walletService;

    @GetMapping("/wallet")
    public String wallet() {
        return walletService.trans();
    }
}
