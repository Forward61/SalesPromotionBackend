package com.freedom.sales.controller;

import com.freedom.sales.pojo.ResponseVos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @Author: freedom
 * @Date: 2022-02-18 18:49
 **/
@CrossOrigin
@RestController
//@RequestMapping("/")
public class YsjgController {
    @Autowired
    ResponseVos responseVos;
    //@PostMapping("/ysjg")
    @RequestMapping(value ="/ysjg",method=RequestMethod.POST,consumes="application/xml")
    @ResponseBody
    public String receiverSMS(@RequestBody RestSMS restSms) {
        HashMap<String,Object> result = new HashMap<String,Object>();
        System.out.println("回调参数："+restSms.toString());

            String returnString = "<Message> <Message_Body> <response> <returnCode>0000</returnCode> <returnMsg>成功</returnMsg><areaCode>05</areaCode><payCode>33333</payCode> <ownerName>业主姓名</ownerName> <ownerCardNo>业主证件号码</ownerCardNo> <houseAddress>房屋地址</houseAddress> <payMoney>1011.00</payMoney> <monAccountNo>7210002223000</monAccountNo> <monAccountName>监管账户</monAccountName> <remark>备注</remark> </response> </Message_Body> </Message>";

        return returnString;
    }

    //public String hello(String name) {
    //    System.out.println("当前时间" + new Date() + name);
    //    String returnString = "<Message> <Message_Body> <returnCode>0000</returnCode> <returnMsg>成功</returnMsg> </Message_Body> </Message>";
    //
    //
    //    return returnString;
    //    //return String.format( new Date() +"Hello %s!", name);
    //}

}
