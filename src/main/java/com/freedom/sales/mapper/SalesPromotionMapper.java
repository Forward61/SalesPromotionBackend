package com.freedom.sales.mapper;

import com.freedom.sales.pojo.SalesPromotionPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SalesPromotionMapper {
    //long countByExample(VaccinumBookingExample example);
    //
    //int deleteByExample(VaccinumBookingExample example);
    //
    //int deleteByPrimaryKey(String id);
    //
    int insert(SalesPromotionPojo record);
    //
    //int insertSelective(VaccinumBooking record);
    //
    List<SalesPromotionPojo> selectAll();

    List<SalesPromotionPojo> selectByGoodsName(String  goodsName);

    SalesPromotionPojo selectByPrimaryKey(String id);

    //int updateByExampleSelective(@Param("record") VaccinumBooking record, @Param("example") VaccinumBookingExample example);
    //
    //int updateByExample(@Param("record") VaccinumBooking record, @Param("example") VaccinumBookingExample example);
    //
    //int updateByPrimaryKeySelective(VaccinumBooking record);
    //
    //int updateByPrimaryKey(VaccinumBooking record);
}