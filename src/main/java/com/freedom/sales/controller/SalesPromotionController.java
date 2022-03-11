package com.freedom.sales.controller;

import com.freedom.sales.mapper.SalesPromotionMapper;
import com.freedom.sales.pojo.SalesPromotionPojo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @Author: freedom
 * @Date: 2021-11-05 09:59
 **/
//@CrossOrigin
@RestController
//@Slf4j
public class SalesPromotionController {
    Logger logger = LogManager.getLogger(SalesPromotionController.class);
    @Autowired
    SalesPromotionMapper salesPromotionMapper;
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        System.out.println("当前时间" + new Date());
        //log.info("我是logger info信息");
        //log.error("我是logger error信息");
        //log.warn("我是logger warn信息");
        //log.debug("我是logger debug信息");
        //log.trace("我是logger trace信息");
        logger.info("我是logger info信息");
        logger.error("我是logger error信息");
        logger.warn("我是logger warn信息");
        logger.debug("我是logger debug信息");
        logger.trace("我是logger trace信息");
        return String.format( new Date() +"Hello %s!", name);
    }

    @RequestMapping(value = "/search/{id}", method = RequestMethod.POST)
    public List<SalesPromotionPojo> searchById(@PathVariable String id) {
        ArrayList list = new ArrayList<String>();
        list.add(salesPromotionMapper.selectByPrimaryKey(id));
        return list;
    }
    @CrossOrigin(origins ="*",maxAge = 3600)
    @RequestMapping(value = "//", method = RequestMethod.POST)
    public List<SalesPromotionPojo> searchByGoodsName() {
        System.out.println("当前时间" + new Date());
        System.out.println("查询全部商品名 " );
        logger.info("当前时间" + new Date());
        logger.info("查询全部商品名" );

        return salesPromotionMapper.selectAll();
    }
//    @CrossOrigin(origins ="*",maxAge = 3600)
    @RequestMapping(value = "/searchAll/", method = RequestMethod.POST)
    public List<SalesPromotionPojo> searchAllGoods() {

        System.out.println("当前时间" + new Date());
        System.out.println("查询全部商品名 " );
        return salesPromotionMapper.selectAll();
    }
    @CrossOrigin(origins ="*",maxAge = 3600)
    @RequestMapping(value = "/searchPastAllGoodsInfo/", method = RequestMethod.POST)
    public HashMap<String,ArrayList> searchPastAllGoodsInfo() {

        System.out.println("当前时间" + new Date());
        System.out.println("查询全部信息" );
        logger.info("当前时间" + new Date());
        logger.info("查询全部信息" );
        HashMap goodsMap = new HashMap<String,ArrayList>();
        goodsMap.put("salesList", salesPromotionMapper.selectAll());
        goodsMap.put("pastsalesList", salesPromotionMapper.selectPastAll());

        return goodsMap;
    }

    @CrossOrigin(origins ="*",maxAge = 3600)
    @RequestMapping(value = "/searchByGoodsName/{goodsName}", method = RequestMethod.POST)
    public List<SalesPromotionPojo> searchByGoodsName(@PathVariable String goodsName) {
        System.out.println("当前时间" + new Date());
        System.out.println("查询商品名 " + goodsName);
        logger.info("当前时间" + new Date());
        logger.info("查询商品名 " + goodsName );
        String __d="dd";
        return salesPromotionMapper.selectByGoodsName(goodsName);
    }
    @CrossOrigin(origins ="*",maxAge = 3600)
    @RequestMapping(value = "/searchByGoodsInfo/{goodsName}", method = RequestMethod.POST)
    public HashMap<String,ArrayList> searchByGoodsInfo(@PathVariable String goodsName) {
        System.out.println("当前时间" + new Date());
        System.out.println("查询商品名 " + goodsName);
        logger.info("当前时间" + new Date());
        logger.info("查询商品名 " + goodsName );
        HashMap goodsMap = new HashMap<String,ArrayList>();
        goodsMap.put("salesList", salesPromotionMapper.selectByGoodsName(goodsName));
        goodsMap.put("pastsalesList", salesPromotionMapper.selectPastGoodsByGoodsName(goodsName));

        return goodsMap;
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
            logger.info("当前时间" + new Date());
            logger.info(" 插入成功  商品名 " + salesPromotionPojo.getGoodsName() );
            return  "1";
        }else {

            System.out.println(salesPromotionPojo.getGoodsName()+" 插入失败");
            logger.info(" 插入失败  商品名 " + salesPromotionPojo.getGoodsName() );

            return  "1";

        }
    }

}
