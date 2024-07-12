package com.nft.constract;

import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.websocket.WebSocketService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;
import org.web3j.utils.Numeric;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.math.BigInteger;
import java.util.List;

@Service
public class ContractInteraction {

    public static String node="wss://sepolia.infura.io/ws/v3/dd1c4241b59f46baa48ba6def42d1702";
    WebSocketService webSocketService;
    Web3j web3j;
    Credentials credentials;
    IPFSStorage contract;
    String contractAddress = "0x41af704710763A353c2b26c0700F5131A3eA285D";
    String WalletPrivateKey="bbfda75cb0ad07c0c3e0e97095ffcdec653339c7f54a7f5a666e2a16e82ad851";
    BigInteger gasPrice = BigInteger.valueOf(20_000_000_000L); // 20 Gwei
    BigInteger gasLimit = BigInteger.valueOf(4_300_000);

    @PostConstruct
    public void init() throws Exception {
        webSocketService = new WebSocketService(node, false);
        webSocketService.connect();
        web3j = Web3j.build(webSocketService);
        credentials = Credentials.create(WalletPrivateKey);
        ContractGasProvider gasProvider = new StaticGasProvider(gasPrice,gasLimit);
        contract = IPFSStorage.load(contractAddress, web3j, credentials, gasProvider);
    }

    @PreDestroy
    public void destroy() throws Exception {
        webSocketService.close();
    }

    public String storeHash(String ipfsHash) throws Exception {
        TransactionReceipt receipt = contract.storeHash(ipfsHash).send();
        List<IPFSStorage.HashStoredEventResponse> events = contract.getHashStoredEvents(receipt);
        if (!events.isEmpty()) {
            byte[] id = events.get(0).id;
            return Numeric.toHexString(id);
        } else {
            throw new RuntimeException("No HashStored event found");
        }
    }

    public String getHash(String idString) throws Exception {
        byte[] id = Numeric.hexStringToByteArray(idString);
        TransactionReceipt receipt = contract.getHash(id).send();
        List<IPFSStorage.HashRetrievedEventResponse> events = contract.getHashRetrievedEvents(receipt);
        if (!events.isEmpty()) {
            IPFSStorage.HashRetrievedEventResponse event = events.get(0);
            return event.ipfsHash;
        } else {
            throw new RuntimeException("No HashRetrieved event found");
        }
    }
}