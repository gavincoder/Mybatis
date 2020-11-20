package com.example.mybatis.cache.service.impl;

import com.example.mybatis.cache.dao.entity.TruckInfo;
import com.example.mybatis.cache.dao.mapper.TruckInfoMapper;
import com.example.mybatis.cache.service.TruckInfoService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TruckInfoServiceImpl implements TruckInfoService {

    @Autowired
    private TruckInfoMapper truckInfoMapper;

    @Override
    @Transactional
    public TruckInfo getTruckInfo(String truckNo) {
        return truckInfoMapper.getTruckInfo(truckNo);
    }
}
