package com.formssi.fisco.bcos.mytask;


import com.formssi.fisco.bcos.domain.MultipartyCalculationTask;
import com.formssi.fisco.bcos.domain.TaskMember;
import com.formssi.fisco.bcos.mapper.MultipartyCalculationTaskMapper;
import com.formssi.fisco.bcos.mapper.TaskMemberMapper;
import com.formssi.fisco.bcos.solidity.PhylogeneticTree;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.DefaultBlockParameter;
import org.fisco.bcos.web3j.protocol.core.methods.response.BcosBlock;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.io.IOException;
import java.math.BigInteger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;


/**
 * Created by Jerry on 2019/1/14.
 */
@Component
public class SyncBlockInfoTask {


    private final static Logger logger = LoggerFactory.getLogger(SyncBlockInfoTask.class);
    @Autowired
    private Web3j web3j;
    @Autowired
    private PhylogeneticTree phylogeneticTree;
    @Autowired
    private MultipartyCalculationTaskMapper multipartyCalculationTaskMapper;
    @Autowired
    private TaskMemberMapper taskMemberMapper;
    @Transactional
   @Async
    public void pushBlockInfoTask(MultipartyCalculationTask multipartyCalculationTask) {


        try {
            BigInteger blockHigh = web3j.getBlockNumber().send().getBlockNumber();
            System.out.println(blockHigh);

        } catch (IOException e) {
            e.printStackTrace();
        }

        Date d = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println("当前时间：" + sdf.format(d));
        //插入区块链
        // string _no,string _name,int256 _joinCount,int256 _dataAmount,int256 _dataSource,string _dataName,string _createUserId,string _createTime,string _finishTime,string _resultFilePath
        TransactionReceipt receipt = null;
        try {
            System.out.println(multipartyCalculationTask.getNo());
            System.out.println(multipartyCalculationTask.getName());
            System.out.println(BigInteger.valueOf(multipartyCalculationTask.getJoinCount()));
            System.out.println(BigInteger.valueOf(multipartyCalculationTask.getDataSource()));
            System.out.println(BigInteger.valueOf(multipartyCalculationTask.getDataAmount()));
            System.out.println(multipartyCalculationTask.getDataName());
            System.out.println(multipartyCalculationTask.getCreateUserId().toString() );
            System.out.println(multipartyCalculationTask.getCreateTime().toString());
            System.out.println(multipartyCalculationTask.getFinishTime().toString());
            System.out.println(multipartyCalculationTask.getResultFilePath());
         receipt = phylogeneticTree.instertMultipartyCalculationTask(multipartyCalculationTask.getNo() ,multipartyCalculationTask.getName(), BigInteger.valueOf(multipartyCalculationTask.getJoinCount()), BigInteger.valueOf(multipartyCalculationTask.getDataAmount()),  BigInteger.valueOf(multipartyCalculationTask.getDataSource()) ,multipartyCalculationTask.getDataName(),multipartyCalculationTask.getCreateUserId().toString() ,multipartyCalculationTask.getCreateTime().toString() ,multipartyCalculationTask.getFinishTime().toString(), multipartyCalculationTask.getResultFilePath()).sendAsync().get();
          // receipt = phylogeneticTree.instertMultipartyCalculationTask("no10" ,"name2" ,BigInteger.valueOf(256) ,BigInteger.valueOf(125) ,BigInteger.valueOf(356) ,"fileuuid" ,"createuserid" ,"createtime",  "result","esultfilename").sendAsync().get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (receipt==null){
            logger.error("(T＿T)===>dealUpChainTask.bal 交易回执为空！");
        }else {
            logger.info("(◉ω◉)===>dealUpChainTask.bal "+receipt.getBlockNumber());
            //获取回执修改数据库
            multipartyCalculationTask.setChainHight(receipt.getBlockNumber().intValue());
            multipartyCalculationTask.setToChainStatus(1);
            multipartyCalculationTask.setToChainTime(d);
            multipartyCalculationTask.setCertificate(receipt.getTransactionHash());
            multipartyCalculationTaskMapper.updateByPrimaryKey(multipartyCalculationTask);
        }

   }

    @Async
    public void pushBlockInfoTask2(TaskMember taskMember) {
        Date d = new Date();
        //插入区块链
        //string _id,string _taskNo,int256 _userId,int256 _role,string _hisoryTaskNo,string _fastaFileUuid,string _fastaFileHash,int256 _fastaDataAmount,string _tsvFileUuid,string _tsvFileHash,int256 _tsvDataAmount
          TransactionReceipt receipt = null;
        try {
            receipt = phylogeneticTree.instertTaskMember(taskMember.getId().toString(),taskMember.getTaskNo(),BigInteger.valueOf(taskMember.getUserId()),BigInteger.valueOf(taskMember.getRole()),taskMember.getHisoryTaskNo(),taskMember.getFastaFileUuid(),taskMember.getFastaFileHash(),BigInteger.valueOf(taskMember.getFastaDataAmount()),taskMember.getTsvFileUuid(),taskMember.getTsvFileHash(),BigInteger.valueOf(taskMember.getTsvDataAmount())).sendAsync().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        if (receipt==null){
            logger.error("(T＿T)===>dealUpChainTask.bal 交易回执为空！");
        }else {
            logger.info("(◉ω◉)===>dealUpChainTask.bal "+receipt.getBlockNumber());
            //获取回执修改数据库
            taskMember.setChainHight(receipt.getBlockNumber().intValue());
            taskMember.setToChainStatus(1);
           taskMember.setToChainTime(d);
            taskMember.setCertificate(receipt.getTransactionHash());
            taskMemberMapper.updateByPrimaryKey(taskMember);
        }

    }
}
