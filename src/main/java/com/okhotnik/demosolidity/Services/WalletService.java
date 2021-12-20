package com.okhotnik.demosolidity.Services;

import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.*;
import org.web3j.utils.Convert;

import java.math.BigDecimal;
import java.math.BigInteger;

@Service
//Робота з рахунком (переказ ефіра на інший рахунок)
public class WalletService {

    private final static String PRIVATE_KEY = "0x3188feacc1bba5318d6c6ff8dc5cfbb441f232e4464d6fb821f44920032a147a";
    private final static String WALLET1 = "0xfdaa58bfb1166ed28f68e992e73039fb10e3f1b4";
    private final static BigInteger GAS_LIMIT = BigInteger.valueOf(21000l);
    private final static BigInteger GAS_PRICE = BigInteger.valueOf(20000000000L);

    Web3j web3j = Web3j.build(new HttpService("https://evmexplorer.testnet.velas.com/rpc"));

    TransactionManager transactionManager = new RawTransactionManager(web3j, getCredentialsFromPrivateKey(), 111);
    Transfer transfer = new Transfer(web3j, transactionManager);

    public String trans() {
        TransactionReceipt transactionReceipt = null;
        try {
            transactionReceipt = transfer.sendFunds(
                    WALLET1,
                    BigDecimal.ONE,
                    Convert.Unit.ETHER,
                    GAS_PRICE,
                    GAS_LIMIT
            ).send();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transactionReceipt.getTransactionHash();
    }

    private Credentials getCredentialsFromPrivateKey() {
        return Credentials.create(PRIVATE_KEY);
    }
}
