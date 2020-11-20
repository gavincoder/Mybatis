package com.example.mybatis.cache;

import com.example.mybatis.cache.dao.entity.TruckInfo;
import com.example.mybatis.cache.dao.mapper.TruckInfoMapper;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public class CacheApplication {
    public static void main(String[] args) throws IOException {
        //1.加载配置（Mybaits数据源配置 + 映射xml）
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

        //2. 从SqlSessionFactory中创建一个SqlSession，进行数据库操作
        SqlSession sqlSession = factory.openSession();

        //3.使用SqlSession查询（基于Statement ID方式）
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("truckNo", "1");
        String statement = "com.example.mybatis.cache.dao.mapper.TruckInfoMapper.getTruckInfo";
        TruckInfo truckInfo = sqlSession.selectOne(statement, params);
        System.out.println(truckInfo);

        //4.使用SqlSession查询（基于Mapper接口代理方式）
        TruckInfoMapper truckInfoMapper = sqlSession.getMapper(TruckInfoMapper.class);
        TruckInfo truckInfo2 = truckInfoMapper.getTruckInfo("1");
        System.out.println(truckInfo2);
        sqlSession.close();


    }


}
//        sqlSession.commit();//所有commit都清理一级缓存（包括查询commit）
