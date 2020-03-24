package com.formssi.fisco.bcos.mytask;

import org.fisco.bcos.web3j.protocol.Web3j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigInteger;

/**
 * Created by Iron on 2019/1/15.
 */
@Component
public class TestTask {
    private static final Logger logger = LoggerFactory.getLogger(TestTask.class);
    
@Autowired
private Web3j web3j;
   //@Async
    public void dealNoReturnTask() {
        logger.info("返回值为void的异步调用开始" + Thread.currentThread().getName());
        try {
            BigInteger blockHigh = web3j.getBlockNumber().send().getBlockNumber();
            System.out.println("块高:"+blockHigh);
            Thread.sleep(6000);
            System.out.println("块高2:"+blockHigh);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        logger.info("返回值为void的异步调用结束" + Thread.currentThread().getName());
    }
    

}
