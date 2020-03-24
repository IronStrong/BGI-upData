//package com.formssi.fisco.bcos.controller;
//
//
//
//import com.formssi.fisco.bcos.dto.BGIReturnJson;
//import com.formssi.fisco.bcos.dto.ReturnJson;
//import com.formssi.fisco.bcos.server.UpChainData;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//
///**
// * @Description: java类作用描述
// * @Author: IronStrong
// * @CreateDate: 2019/3/29 10:02
// * @UpdateUser: 更新者
// * @UpdateDate: 2019/3/29 10:02
// * @UpdateRemark: 更新说明
// * @Version: 1.0
// */
//@RestController
//@RequestMapping("Baas")
//public class UpData {
//    @Autowired
//    public UpChainData upChainData;
//
//    @RequestMapping(value = {"/InsertKV"},method = RequestMethod.POST)
//    public  ReturnJson InsertKV(@RequestParam(value = "flag",required = false,defaultValue = "") String flag,@RequestParam(value = "key",required = false,defaultValue = "") String key, @RequestParam(value = "value",required = false,defaultValue = "") String value){
//
//        String params[]={flag,key,value};
//        ReturnJson returnJson = new ReturnJson();
//        try {
//            BGIReturnJson    BGIToInsert= upChainData.UpChain(params);
//            returnJson.setSuccess(true);
//            returnJson.setMessage("交易执行成功！");
//            returnJson.setObj(BGIToInsert);
//        } catch (Exception e) {
//            returnJson.setSuccess(false);
//            returnJson.setMessage("交易执行失败！");
//            return returnJson;
//        }
//        return returnJson;
//    }
//}
