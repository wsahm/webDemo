package com.tedu.utils;

import java.sql.*;

public class JDBCU {
    private JDBCU(){};
    public static Connection getConnection(){
//        1.注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
//        2.连接数据库
            String url="jdbc:mysql:///jt_db";
            String user="root";
            String password="wsahm1314";
            Connection c = DriverManager.getConnection(url,user,password);
            return c;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void closes(ResultSet r, Statement s,Connection c){
        if (r!=null) {
            try {
                r.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                r=null;
            }
        }
        if (s!=null) {
            try {
                s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                s=null;
            }
        }
        if (c!=null) {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                c=null;
            }
        }
    }
}
