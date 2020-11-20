package com.example.mybatis.cache.controller;

import com.example.mybatis.cache.dao.entity.TruckInfo;
import com.example.mybatis.cache.service.TruckInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gavin
 */
@Slf4j
@RestController
@RequestMapping("/web/truck")
public class TruckInfoController {
    @Autowired
    private TruckInfoService truckInfoService;

    @GetMapping("/getTruckInfo")
    public TruckInfo getTruckInfo(String truckNo) {
        log.info("开始查询货车信息...");
        return truckInfoService.getTruckInfo(truckNo);
    }
}
