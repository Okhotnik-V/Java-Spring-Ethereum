package com.okhotnik.demosolidity.Services;


import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.response.*;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@Service
//Загальнодоступна інформація по гаманцях і клієнту
public class ClientService {

    private final static String WALLET0 = "0xAeED1Fe58f185a817131d7Bc7f2A7c83e6FB9cE3";

    Web3j web3j = Web3j.build(new HttpService("http://127.0.0.1:7545"));

    public String getVersion() throws IOException {
        Web3ClientVersion web3ClientVersion = null;
        web3ClientVersion = web3j.web3ClientVersion().send();
        String clientVersion = web3ClientVersion.getWeb3ClientVersion();
        return clientVersion;
    }

    public EthAccounts getEthAccounts() throws ExecutionException, InterruptedException {
        EthAccounts result = new EthAccounts();
        result = this.web3j.ethAccounts()
                .sendAsync()
                .get();
        return result;
    }

    public EthGetBalance getEthBalance() throws ExecutionException, InterruptedException {
        EthGetBalance result = new EthGetBalance();
        result = this.web3j.ethGetBalance(WALLET0, DefaultBlockParameter.valueOf("latest"))
                .sendAsync()
                .get();
        return result;
    }

    public EthBlockNumber getBlockNumber() throws ExecutionException, InterruptedException {
        EthBlockNumber result = new EthBlockNumber();
        result = this.web3j.ethBlockNumber()
                .sendAsync()
                .get();
        return result;
    }

    public EthGetTransactionCount getTransactionCount() throws ExecutionException, InterruptedException {
        EthGetTransactionCount result = new EthGetTransactionCount();
        result = this.web3j.ethGetTransactionCount(WALLET0,
                DefaultBlockParameter.valueOf("latest"))
                .sendAsync()
                .get();
        return result;
    }
}
