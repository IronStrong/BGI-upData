package com.formssi.fisco.bcos;

import org.fisco.bcos.channel.client.Service;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.crypto.gm.GenCredential;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.channel.ChannelEthereumService;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
@MapperScan("com.formssi.fisco.bcos.mapper")
public class ZhUpDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhUpDataApplication.class, args);
    }

//    @Bean
//    public Web3j getWeb3j(Service service) throws Exception {
//        ChannelEthereumService channelEthereumService = new ChannelEthereumService();
//        service.run();
//        channelEthereumService.setChannelService(service);
//        channelEthereumService.setTimeout(10000);
//        System.out.println(service.getGroupId());
//        return Web3j.build(channelEthereumService,service.getGroupId());
//    }


    @Bean
    public Credentials getCredentials() throws Exception {
        Credentials	credentials = GenCredential.create("b33405550c96ef5ae7d7d9a6b323fa739277bb469546db96c1e2e5690ea871fe");
        if (credentials == null) {
            throw new Exception("create Credentials failed");
        }
        return credentials;
    }
}
