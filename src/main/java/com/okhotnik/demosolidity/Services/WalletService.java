package com.okhotnik.demosolidity.Services;

import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import java.math.BigDecimal;
import java.math.BigInteger;

@Service
//Робота з рахунком (переказ ефіра на інший рахунок)
public class WalletService {

    private final static String PRIVATE_KEY = "3e01d7c9b3d9b4cc0da5a50cbddf9e578d8f04ce39e39ced2e16a5a8ae6c8c47";
    private final static String WALLET1 = "0xAeED1Fe58f185a817131d7Bc7f2A7c83e6FB9cE3";
    private final static BigInteger GAS_LIMIT = BigInteger.valueOf(21000l);
    private final static BigInteger GAS_PRICE = BigInteger.valueOf(20000000000L);

    Web3j web3j = Web3j.build(new HttpService("http://127.0.0.1:7545"));

    TransactionManager transactionManager = new RawTransactionManager(web3j, getCredentialsFromPrivateKey());
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
