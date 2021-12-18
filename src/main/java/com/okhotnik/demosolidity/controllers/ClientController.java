package com.okhotnik.demosolidity.controllers;

import com.okhotnik.demosolidity.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@Controller
public class ClientController {

    @Autowired
    ClientService web3jService;

    @ResponseBody
    @GetMapping("/")
    public String home() throws IOException {
        return "Test";
    }

    @ResponseBody
    @GetMapping("/client/version")
    public String version() throws IOException {
        return web3jService.getVersion();
    }

    @ResponseBody
    @GetMapping("/client/accounts")
    public EthAccounts accounts() throws IOException, ExecutionException, InterruptedException {
        return web3jService.getEthAccounts();
    }

    @ResponseBody
    @GetMapping("/client/balance")
    public EthGetBalance balance() throws IOException, ExecutionException, InterruptedException {
        return web3jService.getEthBalance();
    }

    @ResponseBody
    @GetMapping("/client/block")
    public EthBlockNumber block() throws IOException, ExecutionException, InterruptedException {
        return web3jService.getBlockNumber();
    }

    @ResponseBody
    @GetMapping("/client/transaction")
    public EthGetTransactionCount transaction() throws IOException, ExecutionException, InterruptedException {
        return web3jService.getTransactionCount();
    }
}
