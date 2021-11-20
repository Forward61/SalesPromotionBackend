package com.freedom.sales.controller;

import com.freedom.sales.mapper.SalesPromotionMapper;
import com.freedom.sales.mapper.UserMapper;
import com.freedom.sales.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @Author: freedom
 * @Date: 2021-11-05 09:59
 **/
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserMapper userMapper;

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
    public List<UserPojo> searchByGoodsName() {

        return userMapper.selectAll();
    }

    @CrossOrigin(origins ="*",maxAge = 3600)
    @RequestMapping(value = "/searchByOpenid/{openid}", method = RequestMethod.POST)
    public UserPojo searchByOpenid(@PathVariable String openid) {

        System.out.println("openid" + openid);
        return  userMapper.selectByOpenid(openid);
    }

    @RequestMapping("/insertUserInfo")
    public String insertRecord(UserPojo userPojo){
        //先查询Openid 是否在数据库存在,若存在,则跳过,提示存在
        UserPojo queryData = searchByOpenid(userPojo.getOpenid());
        if (StringUtils.isEmpty(queryData.getId())){

        }else{
            System.out.println(userPojo.getOpenid() + "已经存在,跳过添加");
            return userPojo.getOpenid() + "已经存在,跳过添加";
        }

        //格式化日期时间类型为字符串
        LocalDateTime localDateTime=LocalDateTime.now();

        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String ss = dateTimeFormatter.format(localDateTime).toString();
        System.out.println(ss);
        userPojo.setId(ss + new Random().nextInt(100));
        //vaccinumBooking.setName("name"+ new Random().nextInt(100));
        //salesPromotionPojo.setSex(1);
        int successnum =  userMapper.insert(userPojo);
        if (successnum ==1){
            System.out.println(userPojo.getOpenid()+" 插入成功");
            return  "1";
        }else {

            System.out.println(userPojo.getOpenid()+" 插入失败");
            return  "1";

        }
    }

}
