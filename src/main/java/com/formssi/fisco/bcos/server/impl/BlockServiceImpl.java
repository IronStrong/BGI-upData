package com.formssi.fisco.bcos.server.impl;


import com.formssi.fisco.bcos.dto.Block;
import com.formssi.fisco.bcos.dto.Transaction;
import com.formssi.fisco.bcos.server.BlockService;

import com.formssi.fisco.bcos.solidity.PhylogeneticTree;
import com.formssi.fisco.bcos.solidity.TestInfo;
import javafx.scene.shape.VLineTo;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.DefaultBlockParameter;
import org.fisco.bcos.web3j.protocol.core.methods.response.BcosBlock;

import org.fisco.bcos.web3j.protocol.core.methods.response.BcosTransactionReceipt;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class BlockServiceImpl implements BlockService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Web3j web3j;
	@Autowired
	private PhylogeneticTree phylogeneticTree;

	public int getBlockHigh() throws Exception {
		int high = 0;
		try {
			BigInteger blockHigh = web3j.getBlockNumber().send().getBlockNumber();
			high = Integer.valueOf(String.valueOf(blockHigh));
			logger.debug("getBlockHigh blockchain response:", blockHigh);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("getBlockHigh to blockchain filed!!");
			throw new Exception("getBlockHigh to blockchain made a exception!");
		}
		return high;
	}

	public Block getBlockTransLogInfo(BigInteger blockNumber) throws Exception {
		Block block=new Block();
		try {


//			block = getBlockTransInfo(blockNumber);
//			System.out.println("read blockInfo from blockchain");
//			logger.debug("getBlockTransLogInfo blockchain response:", block);
			return block;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("getBlockTransLogInfo to blockchain filed!!");
			throw new Exception("getBlockTransLogInfo to blockchain made a exception!");
		}

	}




	//公共方法
	public String[] devBlock(String s){

		String sTemp = s.substring(1, s.length()-1);
		String[] sArray = sTemp.split("},");
		if(sArray.length>=2){
		for(int i=0;i<sArray.length-1;i++){
			sArray[i]=sArray[i]+"}";
		}
		}
		return  sArray;
	}


//	public Block getBlockInfo(BigInteger blockNumber) throws Exception {
//		Block returnBlock = new Block();
//		List<Transaction> transactions = new ArrayList<>();
//		BcosBlock ethBlock = null;
//		ethBlock = web3j.getBlockByNumber(DefaultBlockParameter.valueOf(blockNumber), false).send();
//		BcosBlock.Block block = ethBlock.getBlock();
//		returnBlock.setBlockNumber(String.valueOf(blockNumber));
//		BigInteger blockTime = block.getTimestamp();
//		Date blockTime2 = new Date(Long.valueOf(String.valueOf(blockTime)));
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String blockTimeStr = formatter.format(blockTime2);
//		returnBlock.setBlockTime(blockTimeStr);
//		returnBlock.setPreBlockHash(block.getParentHash());
//		returnBlock.setCurrBlockHash(block.getHash());
//		//交易
//		List<BcosBlock.TransactionResult> transactionResults = block.getTransactions();
//		for (BcosBlock.TransactionResult result : transactionResults) {
//        Transaction transaction=new Transaction();
//			System.out.println(result.get().toString());
//			//交易hash
//			transaction.setHash(result.get().toString());
//			//交易hash获取回执
//			BcosTransactionReceipt ethGetTransactionReceipt = null;
//			try {
//				ethGetTransactionReceipt = web3j.getTransactionReceipt((String) result.get()).send();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			Optional<TransactionReceipt> opt = ethGetTransactionReceipt.getTransactionReceipt();
//			if (opt.isPresent()) {
//				TransactionReceipt receipt = opt.get();
//				System.out.println(receipt.getLogs().size());
//				if(receipt.getLogs().size()==0){continue;}
//				transaction.setReceiptData(receipt.getLogs().get(0).getData().toString());
//				TestInfo.TxlogsEventResponse responsesList = testInfo.getTxlogsEvents(receipt).get(0);
//                transaction.setReceiptInfo(responsesList.value);
//
//			}
//			transactions.add(transaction);
//		}
//
//		returnBlock.setTransactions(transactions);
//		return returnBlock;
//
//	}

}

