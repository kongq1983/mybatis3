package com.kq.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Arrays;

/**
 * BatchInsertMoreSql
 *
 * @author kq
 * @date 2019-04-28
 */
public class BatchInsertMoreSql {

    public static void main(String[] args) {
        //声明Connection对象
        Connection con;
        //驱动程序名
        String driver = "com.mysql.cj.jdbc.Driver";
        //URL指向要访问的数据库名mydata
        String url = "jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8&serverTimezone=GMT&useSSL=false";
        //MySQL配置时的用户名
        String user = "root";
        //MySQL配置时的密码
        String password = "123456";
        //遍历查询结果集
        try {
            //加载驱动程序
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.创建statement类对象，用来执行SQL语句！！

            String sql = "insert into account(username,name,age) values(?,?,?)";

//            PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.addBatch("insert into account(username,name,age) values(\"11\",\"11\",\"11\")");
            preparedStatement.addBatch("insert into account(username,name,age) values(\"21\",\"21\",\"21\")");

            int[] updateResults = preparedStatement.executeBatch();

            System.out.println("updateResults="+ Arrays.toString(updateResults));

            preparedStatement.clearBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
