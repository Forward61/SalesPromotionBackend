package com.freedom.sales.mapper;

import com.freedom.sales.pojo.SalesPromotionPojo;
import com.freedom.sales.pojo.UserPojo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: freedom
 * @Date: 2021-11-20 21:44
 **/

@Repository
@Mapper
public interface UserMapper {

    int insert(UserPojo userPojo);
    List<UserPojo> selectAll();
    UserPojo selectByPrimaryKey(String id);
    UserPojo selectByOpenid(String openid);


}
