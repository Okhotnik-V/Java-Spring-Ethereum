package com.okhotnik.demosolidity.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

@SuppressWarnings("rawtypes")
public class Greeting extends Contract {
    public static final String BINARY = "60c0604052600b60808190526a12195b1b1bc815dbdc9b1960aa1b60a090815261002c916000919061003f565b5034801561003957600080fd5b506100da565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061008057805160ff19168380011785556100ad565b828001600101855582156100ad579182015b828111156100ad578251825591602001919060010190610092565b506100b99291506100bd565b5090565b6100d791905b808211156100b957600081556001016100c3565b90565b61037d806100e96000396000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c806319ff1d2114610046578063435ffe94146100c35780638da9b7721461016b575b600080fd5b61004e610173565b6040805160208082528351818301528351919283929083019185019080838360005b83811015610088578181015183820152602001610070565b50505050905090810190601f1680156100b55780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b610169600480360360208110156100d957600080fd5b8101906020810181356401000000008111156100f457600080fd5b82018360208201111561010657600080fd5b8035906020019184600183028401116401000000008311171561012857600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550610201945050505050565b005b61004e610218565b6000805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815292918301828280156101f95780601f106101ce576101008083540402835291602001916101f9565b820191906000526020600020905b8154815290600101906020018083116101dc57829003601f168201915b505050505081565b80516102149060009060208401906102af565b5050565b60008054604080516020601f60026000196101006001881615020190951694909404938401819004810282018101909252828152606093909290918301828280156102a45780601f10610279576101008083540402835291602001916102a4565b820191906000526020600020905b81548152906001019060200180831161028757829003601f168201915b505050505090505b90565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106102f057805160ff191683800117855561031d565b8280016001018555821561031d579182015b8281111561031d578251825591602001919060010190610302565b5061032992915061032d565b5090565b6102ac91905b80821115610329576000815560010161033356fea26469706673582212204acd23c2c7dcce22476f8d620185d86e048e19df626a25b604d01983094947d064736f6c634300060b0033";

    public static final String FUNC_GETHELLO = "getHello";

    public static final String FUNC_HELLO = "hello";

    public static final String FUNC_SETHELLO = "setHello";

    @Deprecated
    protected Greeting(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Greeting(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Greeting(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Greeting(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<String> getHello() {
        final Function function = new Function(FUNC_GETHELLO,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> hello() {
        final Function function = new Function(FUNC_HELLO,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setHello(String newHello) {
        final Function function = new Function(
                FUNC_SETHELLO,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(newHello)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Greeting load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Greeting(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Greeting load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Greeting(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Greeting load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Greeting(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Greeting load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Greeting(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Greeting> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Greeting.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Greeting> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Greeting.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Greeting> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Greeting.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Greeting> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Greeting.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
