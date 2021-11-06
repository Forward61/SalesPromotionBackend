package com.freedom.sales.controller;

import com.freedom.sales.mapper.SalesPromotionMapper;
import com.freedom.sales.pojo.SalesPromotionPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    @RequestMapping(value = "/searchByGoodsName/{goodsName}", method = RequestMethod.POST)
    public List<SalesPromotionPojo> searchByGoodsName(@PathVariable String goodsName) {

        return salesPromotionMapper.selectByGoodsName(goodsName);
    }

}
