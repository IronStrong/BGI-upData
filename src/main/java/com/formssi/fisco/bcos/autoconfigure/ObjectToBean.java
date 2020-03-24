package com.formssi.fisco.bcos.autoconfigure;


import com.formssi.fisco.bcos.solidity.PhylogeneticTree;

import com.formssi.fisco.bcos.utils.PropertiesUtil;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.math.BigInteger;

/**
 * @Description: java类作用描述
 * @Author: IronStrong
 * @CreateDate: 2019/3/12 16:49
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/3/12 16:49
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Configuration
public class ObjectToBean {
 //之后直接从配置文件里面读取
//    contract.address.testinfomapping=0x11ee26d4bc14b203c26c274cc3b0caff92e28222




    @Autowired
    Web3j web3j;
    @Autowired
    Credentials credentials;

    private static BigInteger gasPrice = new BigInteger("300000000");
    private static BigInteger gasLimit = new BigInteger("300000000");

    @Bean
    public PhylogeneticTree getPhylogeneticTree(){
        String testInfoContAddr="";
        try {
            PropertiesUtil.readFile("application.properties");
            testInfoContAddr=PropertiesUtil.readValue("contract.address.PhylogeneticTreeAddr");
        } catch (IOException e) {
            e.printStackTrace();
        }

        PhylogeneticTree phylogeneticTree = PhylogeneticTree.load(testInfoContAddr, web3j, credentials,new StaticGasProvider(gasPrice, gasLimit) );
        return phylogeneticTree;
    }

}
