package com.freedom.sales.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @Author: freedom
 * @Date: 2021-11-05 10:09
 **/
@Data
public class SalesPromotionPojo {
    //id	varchar(30)	No
    //goodsName	varchar(300)	Yes
    //promotionPrice	decimal(20,0)	Yes
    //originalPrice	decimal(20,0)	Yes
    //beginDate	timestamp	Yes
    //endDate	timestamp	Yes
    //maxWeight	double	Yes
    //maxAmount	varchar(10)	Yes
    //imageUrl	varchar(600)	Yes
    //createTime
    private String id;
    private String goodsName;
    private BigDecimal promotionPrice;
    private BigDecimal originalPrice;
    private Date beginDate;
    private Date endDate;
    private Double maxWeight;
    private String maxAmount;
    private String imageUrl;
    private Date createTime;
}
