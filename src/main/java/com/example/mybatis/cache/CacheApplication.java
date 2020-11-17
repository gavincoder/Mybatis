package com.example.mybatis.cache;

import com.example.mybatis.cache.dao.entity.TruckInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class CacheApplication {
    public static void main(String[] args) throws IOException {
        //1.加载配置（Mybaits数据源配置 + 映射xml）
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

        //2. 从SqlSessionFactory中创建一个SqlSession，进行数据库操作
        SqlSession sqlSession1 = factory.openSession();

        //3.使用SqlSession查询
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("truckNo", "1");
        String statement = "com.example.mybatis.cache.dao.mapper.TruckInfoMapper.getTruckInfo";
        //a.sqlSession1第一次查询
        TruckInfo truckInfo = sqlSession1.selectOne(statement, params);
        System.out.println(truckInfo);
        sqlSession1.close();// 进行二级缓存时刻

        //4.新建sqlSession2
        SqlSession sqlSession2 = factory.openSession();
        //b.sqlSession2第一次查询(相同namespace下sql查询，二级缓存命中)
        TruckInfo truckInfo2 = sqlSession2.selectOne(statement, params);
        System.out.println(truckInfo2);

    }


}
//        sqlSession.commit();//所有commit都清理一级缓存（包括查询commit）
