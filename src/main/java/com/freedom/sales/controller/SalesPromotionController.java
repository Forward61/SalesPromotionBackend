package com.freedom.sales.controller;

import com.freedom.sales.mapper.SalesPromotionMapper;
import com.freedom.sales.pojo.SalesPromotionPojo;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SalesPromotionController {

    @Autowired
    SalesPromotionMapper salesPromotionMapper;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        System.out.println("当前时间" + new Date());
        return String.format( new Date() +"Hello %s!", name);
    }

    @RequestMapping(value = "/search/{id}", method = RequestMethod.POST)
    public List<SalesPromotionPojo> searchById(@PathVariable String id) {
        ArrayList list = new ArrayList<String>();
        list.add(salesPromotionMapper.selectByPrimaryKey(id));
        return list;
    }
    @CrossOrigin(origins ="*",maxAge = 3600)
    @RequestMapping(value = "/searchAll/", method = RequestMethod.POST)
    public List<SalesPromotionPojo> searchByGoodsName() {
        System.out.println("当前时间" + new Date());
        System.out.println("查询全部商品名 " );
        return salesPromotionMapper.selectAll();
    }

    @CrossOrigin(origins ="*",maxAge = 3600)
    @RequestMapping(value = "/searchByGoodsName/{goodsName}", method = RequestMethod.POST)
    public List<SalesPromotionPojo> searchByGoodsName(@PathVariable String goodsName) {
        System.out.println("当前时间" + new Date());
        System.out.println("查询商品名 " + goodsName);

        return salesPromotionMapper.selectByGoodsName(goodsName);
    }

    @RequestMapping("/sales/insertGoodsInfo")
    public String insertRecord(SalesPromotionPojo salesPromotionPojo){
        //格式化日期时间类型为字符串
        LocalDateTime localDateTime=LocalDateTime.now();

        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String ss = dateTimeFormatter.format(localDateTime).toString();
        System.out.println(ss);
        salesPromotionPojo.setId(ss + new Random().nextInt(100));
        //vaccinumBooking.setName("name"+ new Random().nextInt(100));
        System.out.println("当前时间" + new Date());
        System.out.println("折扣价格" + salesPromotionPojo.getPromotionPrice());
        //salesPromotionPojo.setSex(1);
        int successnum =  salesPromotionMapper.insert(salesPromotionPojo);
        if (successnum ==1){
            System.out.println(salesPromotionPojo.getGoodsName()+" 插入成功");
            return  "1";
        }else {

            System.out.println(salesPromotionPojo.getGoodsName()+" 插入失败");
            return  "1";

        }
    }

}
