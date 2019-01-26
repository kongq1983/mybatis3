package com.kq;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionManager;
import org.junit.BeforeClass;

import java.io.Reader;

/**
 * BaseTest
 *
 * @author kq
 * @date 2019-01-26
 */
public class BaseTest {

    protected static SqlSessionFactory sessionFactory;
    protected static SqlSessionManager sqlSessionManager;

    final static String resource = "myconfig/mybatis-config.xml";

    @BeforeClass
    public static void setup() throws Exception {
//        createBlogDataSource();

        final Reader reader = Resources.getResourceAsReader(resource);
        sqlSessionManager = SqlSessionManager.newInstance(reader);
        sessionFactory = (SqlSessionFactory)sqlSessionManager;
    }


}
