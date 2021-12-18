package com.okhotnik.demosolidity.Services;

import com.okhotnik.demosolidity.contracts.Greeting;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;

import java.math.BigInteger;

@Service
//Робота з Смарт-Контрактом
public class ContractService {

    private final static String PRIVATE_KEY = "3e01d7c9b3d9b4cc0da5a50cbddf9e578d8f04ce39e39ced2e16a5a8ae6c8c47";
    private final static BigInteger GAS_LIMIT = BigInteger.valueOf(2100000l);
    private final static BigInteger GAS_PRICE = BigInteger.valueOf(20000000000L);
    private final static String CONTRACT_ADDRESS = "0x4f0630113b9033df1a1e3ef00fa9a2790171482a";

    Web3j web3j = Web3j.build(new HttpService("http://127.0.0.1:7545"));

    private Credentials getCredentialsFromPrivateKey() {
        return Credentials.create(PRIVATE_KEY);
    }

    public String deployContract() throws Exception {
        return String.valueOf(Greeting.deploy(web3j, getCredentialsFromPrivateKey(), GAS_PRICE, GAS_LIMIT).send().getContractAddress());
    }

    public Greeting loadContract() {
        return Greeting.load(CONTRACT_ADDRESS, web3j, getCredentialsFromPrivateKey(), GAS_PRICE, GAS_LIMIT);
    }

    public String getHello() throws Exception {
        Greeting greeting = loadContract();
        return greeting.getHello().send();
    }

    public String setHello(String text) throws Exception {
        Greeting greeting = loadContract();
        greeting.setHello(text).send();
        return greeting.getHello().send();
    }
}
