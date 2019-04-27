package com.kq.jdbc;

import java.sql.*;

/**
 * GetInsertIdDemo
 *
 * @author kq
 * @date 2019-04-27
 */
public class GetInsertIdDemo {

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

            PreparedStatement preparedStatement = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

            //start widh 1
            preparedStatement.setString(1,"6");
            preparedStatement.setString(2,"6");
            preparedStatement.setString(3,"6");


            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);

            System.out.println("id="+id);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
