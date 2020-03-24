package com.formssi.fisco.bcos.scheduled;


import com.formssi.fisco.bcos.domain.MultipartyCalculationTask;
import com.formssi.fisco.bcos.domain.TaskMember;
import com.formssi.fisco.bcos.mapper.MultipartyCalculationTaskMapper;
import com.formssi.fisco.bcos.mapper.TaskMemberMapper;
import com.formssi.fisco.bcos.mytask.SyncBlockInfoTask;
import com.formssi.fisco.bcos.mytask.TestTask;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.methods.response.BcosBlock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.channels.MulticastChannel;
import java.util.List;


@Component
public class QueryBlockNum {
    
    private final static Logger logger = LoggerFactory.getLogger(QueryBlockNum.class);
    

    @Autowired
    Web3j web3j;
    @Autowired
    private SyncBlockInfoTask syncTask;
    @Autowired
    private TestTask testTask;
    @Autowired
    private MultipartyCalculationTaskMapper multipartyCalculationTaskMapper;
    @Autowired
    private TaskMemberMapper taskMemberMapper;

    @Scheduled(fixedRate = 5000)
    public void getBlockInfo(){
      //  testTask.dealNoReturnTask();
           //查询数据库的数据
        List<MultipartyCalculationTask> multipartyCalculationTasksList= multipartyCalculationTaskMapper.findAllDataByStatus();
        for (MultipartyCalculationTask result : multipartyCalculationTasksList) {
            syncTask.pushBlockInfoTask(result);
        }

        List<TaskMember> taskMembers=taskMemberMapper.FindAllTaskMemeberNoChain();
        for (TaskMember result : taskMembers) {
            syncTask.pushBlockInfoTask2(result);
        }

    }
}
