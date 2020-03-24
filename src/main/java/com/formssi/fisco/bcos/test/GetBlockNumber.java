package com.formssi.fisco.bcos.test;



import com.formssi.fisco.bcos.solidity.PhylogeneticTree;
import com.formssi.fisco.bcos.solidity.TestInfo;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.crypto.gm.GenCredential;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.channel.ChannelEthereumService;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.fisco.bcos.channel.client.Service;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertTrue;

/**
 * @Description: java类作用描述
 * @Author: IronStrong
 * @CreateDate: 2019/3/11 16:45
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/3/11 16:45
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class GetBlockNumber {
    private static Logger logger = LoggerFactory.getLogger(GetBlockNumber.class);
    private static BigInteger gasPrice = new BigInteger("300000000");
    private static BigInteger gasLimit = new BigInteger("300000000");
    private static Credentials credentials;
    private static ApplicationContext context=null;



    public static void main(String[] args) throws Exception {

        context = new ClassPathXmlApplicationContext("classpath:fisco-bcos/applicationContext.xml");
        Service service = context.getBean(Service.class);
        service.run();


        ChannelEthereumService channelEthereumService = new ChannelEthereumService();

        channelEthereumService.setChannelService(service);
        channelEthereumService.setTimeout(10000);
        Web3j web3j =Web3j.build(channelEthereumService,service.getGroupId());

        credentials = GenCredential.create("b33405550c96ef5ae7d7d9a6b323fa739277bb469546db96c1e2e5690ea871fe");
      if (credentials == null) {
            throw new Exception("create Credentials failed");
      }

//查询块高
        getBlockHeight(web3j);


        transcation2(web3j);
    //部署合约
    //  deployContract(web3j);

     //合约里面赋值
      // transcation(web3j);



}

public static void  getBlockHeight(Web3j web3j){
    BigInteger blockNumber = null;
    try {
        blockNumber = web3j.getBlockNumber().send().getBlockNumber();
    } catch (IOException e) {
        e.printStackTrace();
    }
    System.out.println(blockNumber);
    assertTrue(blockNumber.compareTo(new BigInteger("0"))>= 0);
}


public static void deployContract( Web3j web3j) throws Exception {
    //deploy contract
        TestInfo testInfo = TestInfo.deploy(web3j, credentials, new StaticGasProvider(gasPrice, gasLimit)).send();
        if (testInfo != null) {
            System.out.println("orderBalanceVerify address is: " + testInfo.getContractAddress());


        }



}

//交易
    public static void transcation(Web3j web3j) throws ExecutionException, InterruptedException {
        // contractGasProvider aa =new contractGasProvider();

        String Addr="0x8c17cf316c1063ab6c89df875e96c9f0f5b2f744";
        TestInfo testInfo = TestInfo.load(Addr, web3j, credentials,new StaticGasProvider(gasPrice, gasLimit) );

       TransactionReceipt receipt = testInfo.saveData(BigInteger.valueOf(1), "song2", "tie2").sendAsync().get();
        if (receipt==null){
            logger.error("(T＿T)===>dealUpChainTask.bal 交易回执为空！");
        }else {
            logger.info("(◉ω◉)===>dealUpChainTask.bal "+receipt.getBlockNumber());
        }


        List<TestInfo.TxlogsEventResponse> eventList= testInfo.getTxlogsEvents(receipt);
        if (eventList.size()==0){
            logger.error("(T＿T)===>dealUpChainTask.bal eventList为空");
        }else {
            logger.info("(◉ω◉)===>dealUpChainTask.bal "+eventList.get(0).key);
        }
        logger.info("(◉ω◉)==|-------------------------|=> UpchainTask 执行完成!!  bal.getOrdNo()=");

    }



    //交易
    public static void transcation2(Web3j web3j) throws ExecutionException, InterruptedException {
        // contractGasProvider aa =new contractGasProvider();

        String Addr="0xe4fdde2335c698948ff806456d5a52d2bbe2c228";
        PhylogeneticTree phylogeneticTree = PhylogeneticTree.load(Addr, web3j, credentials,new StaticGasProvider(gasPrice, gasLimit) );

       // string _no,string _name,int256 _joinCount,int256 _dataAmount,int256 _dataSource,string _dataName,string _createUserId,string _createTime,string _finishTime,string _resultFilePath
        TransactionReceipt receipt = phylogeneticTree.instertMultipartyCalculationTask("no1" ,"name2" ,BigInteger.valueOf(256) ,BigInteger.valueOf(125) ,BigInteger.valueOf(356) ,"fileuuid" ,"createuserid" ,"createtime",  "result","esultfilename").sendAsync().get();
        if (receipt==null){
            logger.error("(T＿T)===>dealUpChainTask.bal 交易回执为空！");
        }else {
            logger.info("(◉ω◉)===>dealUpChainTask.bal "+receipt.getBlockNumber());
        }


        List<PhylogeneticTree.TxlogsEventResponse> eventList= phylogeneticTree.getTxlogsEvents(receipt);
        if (eventList.size()==0){
            logger.error("(T＿T)===>dealUpChainTask.bal eventList为空");
        }else {
            logger.info("(◉ω◉)===>dealUpChainTask.bal "+eventList.get(0).OrderNo);
        }
        logger.info("(◉ω◉)==|-------------------------|=> UpchainTask 执行完成!!  bal.getOrdNo()=");

    }




}
