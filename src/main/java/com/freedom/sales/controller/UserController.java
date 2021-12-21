package com.freedom.sales.controller;

import com.alibaba.fastjson.JSONObject;
import com.freedom.sales.mapper.UserMapper;
import com.freedom.sales.pojo.ResponseVos;
import com.freedom.sales.pojo.UserPojo;
import com.freedom.sales.pojo.WechatConfigPojo;
import com.freedom.sales.utils.HttpClientManager;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @Author: freedom
 * @Date: 2021-11-05 09:59
 **/
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    UserPojo userPojo;
    @Autowired
    UserMapper userMapper;

    @Autowired
    WechatConfigPojo wechatConfigPojo;

    @Autowired
    ResponseVos responseVos;
    @GetMapping("/hello1")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        System.out.println("当前时间" + new Date());
        return String.format( new Date() +"Hello %s!", name);
    }

    @RequestMapping(value = "/search/{id}", method = RequestMethod.POST)
    public List<UserPojo> searchById(@PathVariable String id) {
        ArrayList list = new ArrayList<String>();
        list.add(userMapper.selectByPrimaryKey(id));
        return list;
    }
    @CrossOrigin(origins ="*",maxAge = 3600)
    @RequestMapping(value = "/searchAll/", method = RequestMethod.POST)
    public List<UserPojo> searchAllUserInfo() {
        System.out.println("当前时间" + new Date());
        System.out.println("查询全部信息" );
        logger.info("当前时间" + new Date());
        logger.info("查询全部信息" );

        return userMapper.selectAll();
    }


    @CrossOrigin(origins ="*",maxAge = 3600)
    @RequestMapping(value = "/searchByOpenid/{openid}", method = RequestMethod.POST)
    public UserPojo searchByOpenid(@PathVariable String openid) {
        System.out.println("当前时间" + new Date());
        System.out.println("查询 openid:" + openid);
        logger.info("当前时间" + new Date());
        logger.info("查询 openid:" + openid );
        return  userMapper.selectByOpenid(openid);
    }

    @RequestMapping("/insertUserInfo")
    public String insertRecord(UserPojo userPojo){
        System.out.println("当前时间" + new Date());

        //先查询Openid 是否在数据库存在,若存在,则跳过,提示存在
        UserPojo queryData = searchByOpenid(userPojo.getOpenid());
        if (null == queryData || StringUtils.isEmpty(queryData.getId())){

        }else{
            logger.info("当前时间" + new Date());
            logger.info(userPojo.getOpenid() + "已经存在,跳过添加" );
            System.out.println(userPojo.getOpenid() + "已经存在,跳过添加");
            return "0000";
        }

        //格式化日期时间类型为字符串
        LocalDateTime localDateTime=LocalDateTime.now();

        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String ss = dateTimeFormatter.format(localDateTime).toString();
        System.out.println(ss);
        userPojo.setId(ss + new Random().nextInt(100));

        int successnum =  userMapper.insert(userPojo);
        if (successnum ==1){
            System.out.println(userPojo.getOpenid()+" 插入成功");
            logger.info("当前时间" + new Date());
            logger.info(userPojo.getOpenid()+" 插入成功" );

            return  "1";
        }else {

            System.out.println(userPojo.getOpenid()+" 插入失败");
            logger.info("当前时间" + new Date());
            logger.info(userPojo.getOpenid()+" 插入失败");

            return  "0";

        }
    }

    /**
     * 微信授权登录
     * @return
     * @throws Exception
     */
    @RequestMapping("/getWechatLogin")
    public ResponseVos getWechatLogin(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {

        //微信公众号的APPID和APPSECRET
        String code = request.getParameter("code");
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + wechatConfigPojo.getAppId() +
                "&secret=" + wechatConfigPojo.getSecret() +
                "&js_code=" + code +
                "&grant_type=authorization_code";
        String result = HttpClientManager.getUrlData(url);
        if (result.contains("errcode")) {
            responseVos.setRespCode("错误code");
            return responseVos;

        }
        Map<String, Object> data = JSONObject.parseObject(result);
        String openid = data.get("openid").toString();
        userPojo.setOpenid(openid);
        String returnCode =  insertRecord(userPojo);

        if ("0".equals(returnCode)) {
            //根据场景不一样，授权成功后，在这里做一些业务逻辑的处理

            responseVos.setRespCode("8888");
            responseVos.setRespMsg("需要重新授权");
            responseVos.setOpenId(openid);

            return responseVos;
        }

        String token = data.get("session_key").toString();
        String tokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + wechatConfigPojo.getAppId() +
                "&secret=" + wechatConfigPojo.getSecret();
        String tokenResult = HttpClientManager.getUrlData(tokenUrl);
        Map<String, Object> tokenMap = JSONObject.parseObject(tokenResult);
        responseVos.setOpenId(openid);


        if (StringUtils.isNotEmpty((String) tokenMap.get("access_token"))) {
            //根据场景不一样，授权成功后，在这里做一些业务逻辑的处理

            responseVos.setRespCode("0000");
            responseVos.setRespMsg("获取授权成功");
            responseVos.setOpenId(openid);

            return responseVos;
        } else {
            responseVos.setRespCode("9999");
            responseVos.setRespMsg("获取授权失败");

            return responseVos;
        }
    }


}
