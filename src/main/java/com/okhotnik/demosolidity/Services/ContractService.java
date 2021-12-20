package com.okhotnik.demosolidity.Services;

import com.okhotnik.demosolidity.contracts.Greeting;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.Transfer;

import java.math.BigInteger;

@Service
//Робота з Смарт-Контрактом
public class ContractService {

    private final static String PRIVATE_KEY = "0x3188feacc1bba5318d6c6ff8dc5cfbb441f232e4464d6fb821f44920032a147a";
    private final static BigInteger GAS_LIMIT = BigInteger.valueOf(2100000l);
    private final static BigInteger GAS_PRICE = BigInteger.valueOf(20000000000L);
    private final static String CONTRACT_ADDRESS = "0xfd47113078d3225b84a091a95a26379977080e35";

    Web3j web3j = Web3j.build(new HttpService("https://evmexplorer.testnet.velas.com/rpc"));

    private Credentials getCredentialsFromPrivateKey() {
        return Credentials.create(PRIVATE_KEY);
    }

    TransactionManager transactionManager = new RawTransactionManager(web3j, getCredentialsFromPrivateKey(), 111);

    public String deployContract() throws Exception {
        return String.valueOf(Greeting.deploy(web3j, transactionManager, GAS_PRICE, GAS_LIMIT).send().getContractAddress());
    }

    public Greeting loadContract() {
        return Greeting.load(CONTRACT_ADDRESS, web3j, transactionManager, GAS_PRICE, GAS_LIMIT);
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
