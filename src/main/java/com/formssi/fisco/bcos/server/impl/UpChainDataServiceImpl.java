//package com.formssi.fisco.bcos.server.impl;
//
//import com.formssi.fisco.bcos.dto.BGIReturnJson;
//
//import com.formssi.fisco.bcos.server.UpChainData;
//
//
//import com.formssi.fisco.bcos.solidity.TestInfo;
//import org.fisco.bcos.web3j.protocol.Web3j;
//
//import org.fisco.bcos.web3j.protocol.core.RemoteCall;
//import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.math.BigInteger;
//import java.util.List;
//import java.util.concurrent.ExecutionException;
//
//
//@Service
//public class UpChainDataServiceImpl implements UpChainData {
//    private final static Logger logger = LoggerFactory.getLogger(UpChainDataServiceImpl.class);
//
//    @Autowired
//    private Web3j web3j;
//    @Autowired
//    private TestInfo testInfo;
//
//    public BGIReturnJson UpChain(String[] args) {
//        BGIReturnJson returnJson = new BGIReturnJson();
//        BigInteger flag = new BigInteger(args[0]);
//        String key = args[1];
//        String value = args[2];
//
//     TransactionReceipt receipt = null;
//        try {
//            receipt = testInfo.saveData(flag, key, value).sendAsync().get();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        if (receipt == null) {
//            logger.error("(T＿T)===>dealUpChainTask.bal 交易回执为空！");
//        } else {
////            if (receipt.getLogs().size() != 0) {
////                List<TestInfo.TxlogsEventResponse> responses = testInfo.getTxlogsEvents(receipt);
////                TestInfo.TxlogsEventResponse a = responses.get(0);
////                BigInteger flag2 = responses.get(0).flag;
////                System.out.println(a.toString());
////            }
//            logger.debug("(T＿T)===>dealUpChainTask.bal 交易回执返回");
//        }
//        returnJson.setNumber(receipt.getBlockNumber().toString());
//        returnJson.setTxID(receipt.getTransactionHash());
//
//
//        return returnJson;
//    }
//
//}
