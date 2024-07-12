package com.nft.constract;


import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.5.5.
 */
@SuppressWarnings("rawtypes")
public class IPFSStorage extends Contract {
    private static final String BINARY = "6080604052348015600e575f80fd5b50610cbf8061001c5f395ff3fe608060405234801561000f575f80fd5b5060043610610055575f3560e01c80631e105291146100595780633cf5040a1461008957806371dc61cb146100b95780638a08677d146100e9578063bee51f3b14610119575b5f80fd5b610073600480360381019061006e91906104d3565b610149565b604051610080919061056e565b60405180910390f35b6100a3600480360381019061009e91906104d3565b6101e3565b6040516100b0919061056e565b60405180910390f35b6100d360048036038101906100ce91906106ba565b610328565b6040516100e09190610710565b60405180910390f35b61010360048036038101906100fe91906106ba565b6103d9565b6040516101109190610710565b60405180910390f35b610133600480360381019061012e91906106ba565b610406565b6040516101409190610710565b60405180910390f35b5f602052805f5260405f205f91509050805461016490610756565b80601f016020809104026020016040519081016040528092919081815260200182805461019090610756565b80156101db5780601f106101b2576101008083540402835291602001916101db565b820191905f5260205f20905b8154815290600101906020018083116101be57829003601f168201915b505050505081565b60605f805f8481526020019081526020015f20805461020190610756565b905011610243576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161023a906107d0565b60405180910390fd5b817f9b3c7ec6c667ba6f3ebded25db4932942296abe75384d2a6a8a8061f8a1718c65f808581526020019081526020015f206040516102829190610881565b60405180910390a25f808381526020019081526020015f2080546102a590610756565b80601f01602080910402602001604051908101604052809291908181526020018280546102d190610756565b801561031c5780601f106102f35761010080835404028352916020019161031c565b820191905f5260205f20905b8154815290600101906020018083116102ff57829003601f168201915b50505050509050919050565b5f8082334260405160200161033f93929190610979565b604051602081830303815290604052805190602001209050825f808381526020019081526020015f2090816103749190610b3c565b50806001846040516103869190610c0b565b908152602001604051809103902081905550807f1c9a25e6f41144b868e40b08babed4836933f7ca2065e184790f2993dd708c4a846040516103c8919061056e565b60405180910390a280915050919050565b6001818051602081018201805184825260208301602085012081835280955050505050505f915090505481565b5f805f1b60018360405161041a9190610c0b565b90815260200160405180910390205403610469576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161046090610c6b565b60405180910390fd5b6001826040516104799190610c0b565b9081526020016040518091039020549050919050565b5f604051905090565b5f80fd5b5f80fd5b5f819050919050565b6104b2816104a0565b81146104bc575f80fd5b50565b5f813590506104cd816104a9565b92915050565b5f602082840312156104e8576104e7610498565b5b5f6104f5848285016104bf565b91505092915050565b5f81519050919050565b5f82825260208201905092915050565b8281835e5f83830152505050565b5f601f19601f8301169050919050565b5f610540826104fe565b61054a8185610508565b935061055a818560208601610518565b61056381610526565b840191505092915050565b5f6020820190508181035f8301526105868184610536565b905092915050565b5f80fd5b5f80fd5b7f4e487b71000000000000000000000000000000000000000000000000000000005f52604160045260245ffd5b6105cc82610526565b810181811067ffffffffffffffff821117156105eb576105ea610596565b5b80604052505050565b5f6105fd61048f565b905061060982826105c3565b919050565b5f67ffffffffffffffff82111561062857610627610596565b5b61063182610526565b9050602081019050919050565b828183375f83830152505050565b5f61065e6106598461060e565b6105f4565b90508281526020810184848401111561067a57610679610592565b5b61068584828561063e565b509392505050565b5f82601f8301126106a1576106a061058e565b5b81356106b184826020860161064c565b91505092915050565b5f602082840312156106cf576106ce610498565b5b5f82013567ffffffffffffffff8111156106ec576106eb61049c565b5b6106f88482850161068d565b91505092915050565b61070a816104a0565b82525050565b5f6020820190506107235f830184610701565b92915050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52602260045260245ffd5b5f600282049050600182168061076d57607f821691505b6020821081036107805761077f610729565b5b50919050565b7f4861736820646f6573206e6f74206578697374000000000000000000000000005f82015250565b5f6107ba601383610508565b91506107c582610786565b602082019050919050565b5f6020820190508181035f8301526107e7816107ae565b9050919050565b5f819050815f5260205f209050919050565b5f815461080c81610756565b6108168186610508565b9450600182165f8114610830576001811461084657610878565b60ff198316865281151560200286019350610878565b61084f856107ee565b5f5b8381101561087057815481890152600182019150602081019050610851565b808801955050505b50505092915050565b5f6020820190508181035f8301526108998184610800565b905092915050565b5f81905092915050565b5f6108b5826104fe565b6108bf81856108a1565b93506108cf818560208601610518565b80840191505092915050565b5f73ffffffffffffffffffffffffffffffffffffffff82169050919050565b5f610904826108db565b9050919050565b5f8160601b9050919050565b5f6109218261090b565b9050919050565b5f61093282610917565b9050919050565b61094a610945826108fa565b610928565b82525050565b5f819050919050565b5f819050919050565b61097361096e82610950565b610959565b82525050565b5f61098482866108ab565b91506109908285610939565b6014820191506109a08284610962565b602082019150819050949350505050565b5f6020601f8301049050919050565b5f82821b905092915050565b5f600883026109fb7fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff826109c0565b610a0586836109c0565b95508019841693508086168417925050509392505050565b5f819050919050565b5f610a40610a3b610a3684610950565b610a1d565b610950565b9050919050565b5f819050919050565b610a5983610a26565b610a6d610a6582610a47565b8484546109cc565b825550505050565b5f90565b610a81610a75565b610a8c818484610a50565b505050565b5b81811015610aaf57610aa45f82610a79565b600181019050610a92565b5050565b601f821115610af457610ac5816107ee565b610ace846109b1565b81016020851015610add578190505b610af1610ae9856109b1565b830182610a91565b50505b505050565b5f82821c905092915050565b5f610b145f1984600802610af9565b1980831691505092915050565b5f610b2c8383610b05565b9150826002028217905092915050565b610b45826104fe565b67ffffffffffffffff811115610b5e57610b5d610596565b5b610b688254610756565b610b73828285610ab3565b5f60209050601f831160018114610ba4575f8415610b92578287015190505b610b9c8582610b21565b865550610c03565b601f198416610bb2866107ee565b5f5b82811015610bd957848901518255600182019150602085019450602081019050610bb4565b86831015610bf65784890151610bf2601f891682610b05565b8355505b6001600288020188555050505b505050505050565b5f610c1682846108ab565b915081905092915050565b7f494420646f6573206e6f742065786973740000000000000000000000000000005f82015250565b5f610c55601183610508565b9150610c6082610c21565b602082019050919050565b5f6020820190508181035f830152610c8281610c49565b905091905056fea2646970667358221220b56caa9a070622dde694157f6b2709f37b3aa75bdf4cb654d43a74d5f6ed048564736f6c63430008190033";

    public static final String FUNC_GETHASH = "getHash";

    public static final String FUNC_GETID = "getId";

    public static final String FUNC_IDS = "ids";

    public static final String FUNC_IPFSHASHES = "ipfsHashes";

    public static final String FUNC_STOREHASH = "storeHash";

    public static final Event HASHRETRIEVED_EVENT = new Event("HashRetrieved", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event HASHSTORED_EVENT = new Event("HashStored", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Utf8String>() {}));
    ;

    @Deprecated
    protected IPFSStorage(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected IPFSStorage(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected IPFSStorage(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected IPFSStorage(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<HashRetrievedEventResponse> getHashRetrievedEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(HASHRETRIEVED_EVENT, transactionReceipt);
        ArrayList<HashRetrievedEventResponse> responses = new ArrayList<HashRetrievedEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            HashRetrievedEventResponse typedResponse = new HashRetrievedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.id = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.ipfsHash = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<HashRetrievedEventResponse> hashRetrievedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, HashRetrievedEventResponse>() {
            @Override
            public HashRetrievedEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(HASHRETRIEVED_EVENT, log);
                HashRetrievedEventResponse typedResponse = new HashRetrievedEventResponse();
                typedResponse.log = log;
                typedResponse.id = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.ipfsHash = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<HashRetrievedEventResponse> hashRetrievedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(HASHRETRIEVED_EVENT));
        return hashRetrievedEventFlowable(filter);
    }

    public List<HashStoredEventResponse> getHashStoredEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(HASHSTORED_EVENT, transactionReceipt);
        ArrayList<HashStoredEventResponse> responses = new ArrayList<HashStoredEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            HashStoredEventResponse typedResponse = new HashStoredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.id = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.ipfsHash = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<HashStoredEventResponse> hashStoredEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, HashStoredEventResponse>() {
            @Override
            public HashStoredEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(HASHSTORED_EVENT, log);
                HashStoredEventResponse typedResponse = new HashStoredEventResponse();
                typedResponse.log = log;
                typedResponse.id = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.ipfsHash = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<HashStoredEventResponse> hashStoredEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(HASHSTORED_EVENT));
        return hashStoredEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> getHash(byte[] _id) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_GETHASH, 
                Arrays.<Type>asList(new Bytes32(_id)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> getId(String _ipfsHash) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_GETID, 
                Arrays.<Type>asList(new Utf8String(_ipfsHash)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> ids(String param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_IDS, 
                Arrays.<Type>asList(new Utf8String(param0)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> ipfsHashes(byte[] param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_IPFSHASHES, 
                Arrays.<Type>asList(new Bytes32(param0)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> storeHash(String _ipfsHash) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_STOREHASH, 
                Arrays.<Type>asList(new Utf8String(_ipfsHash)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static IPFSStorage load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new IPFSStorage(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static IPFSStorage load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new IPFSStorage(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static IPFSStorage load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new IPFSStorage(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static IPFSStorage load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new IPFSStorage(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<IPFSStorage> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IPFSStorage.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<IPFSStorage> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IPFSStorage.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<IPFSStorage> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IPFSStorage.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<IPFSStorage> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IPFSStorage.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class HashRetrievedEventResponse extends BaseEventResponse {
        public byte[] id;

        public String ipfsHash;
    }

    public static class HashStoredEventResponse extends BaseEventResponse {
        public byte[] id;

        public String ipfsHash;
    }
}
