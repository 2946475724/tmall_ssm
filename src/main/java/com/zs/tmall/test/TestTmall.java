package com.zs.tmall.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTmall {
    public static void main(String args[]){
        //准备测试的数据
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmall_ssm?useUnicode=true&characterEncoding=utf8",
                    "root","123");
            Statement stat = conn.createStatement();
            for (int i = 0; i <= 10; i++){
                String sqlFormat = "insert into category values (null,'测试分类%d')";
                String sql = String.format(sqlFormat,i);
                stat.execute(sql);
            }
            System.out.println("已经成功创建10条分类测试数据");
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}
