package com.example.mybatis.cache.dao.mapper;

import com.example.mybatis.cache.dao.entity.TruckInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TruckInfoMapper {
    TruckInfo getTruckInfo(@Param("truckNo") String truckNo);

}
