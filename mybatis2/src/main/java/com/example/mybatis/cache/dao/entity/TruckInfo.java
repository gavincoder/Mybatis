package com.example.mybatis.cache.dao.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class TruckInfo implements Serializable {
    /**
     * id
     */
    private String id;

    /**
     * 货车系统编号
     */
    private String truckNo;

    /**
     * 车牌号
     */
    private String plateNumber;

    /**
     * 车主
     */
    private String owner;

    /**
     * 品牌
     */
    private String brand;

}
