package com.formssi.fisco.bcos.controller;

import com.formssi.fisco.bcos.dto.Block;
import com.formssi.fisco.bcos.dto.ReturnJson;
import com.formssi.fisco.bcos.server.BlockService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.math.BigInteger;

@RestController
@RequestMapping("BlockChain")
public class BlockController {

    @Autowired
    private BlockService blockService;

    /**
     * 查询最新块高
     * @param response
     * @return
     */
    @RequestMapping(value = "/queryLastBlockHigh", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String queryLastBlockHigh(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");//跨域访问

        ReturnJson returnJson = new ReturnJson();

        try {
            int blockHigh = blockService.getBlockHigh();
            returnJson.setSuccess(true);
            returnJson.setMessage("查询区块链块高成功！");
            returnJson.setObj(blockHigh);
        }catch(Exception e) {
            returnJson.setSuccess(false);
            returnJson.setMessage("查询区块链块高失败！");
            return returnJson.toJSON();
        }

        return returnJson.toJSON();
    }

    /**
     * 根据块高查询块中信息
     * @param response
     * @return
     */
//    @RequestMapping(value = "/queryBlockByHeight", produces = "application/json;charset=UTF-8")
//    @ResponseBody
//    public String queryBlockByHeight(@RequestParam(value = "num",required = false,defaultValue = "2") String num, HttpServletResponse response) {
//        response.setHeader("Access-Control-Allow-Origin", "*");//跨域访问
//        System.out.println(num );
//        ReturnJson returnJson = new ReturnJson();
//        try {
//            BigInteger numInt =new BigInteger(num);
//            Block block = blockService.getBlockInfo(numInt);
//            returnJson.setSuccess(true);
//            returnJson.setMessage("通过块高查询区块链信息成功！");
//            returnJson.setObj(block);
//        }catch(Exception e) {
//            returnJson.setSuccess(false);
//            returnJson.setMessage("通过块高查询区块链信息失败！");
//            return returnJson.toJSON();
//        }
//
//        return returnJson.toJSON();
//    }

}
