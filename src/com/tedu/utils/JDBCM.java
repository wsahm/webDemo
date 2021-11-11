package com.tedu.utils;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCM {
    private JDBCM(){};
    public static MongoClient getConnection(){
        MongoClient mongoClient=null;
        try {
            //1.不通过认证连接mongodb服务
            mongoClient=new MongoClient();

            /*//2.通过认证连接MongoDB数据库
            List<ServerAddress> adds = new ArrayList<>();
            //ServerAddress()两个参数分别为 服务器地址 和 端口
            ServerAddress serverAddress = new ServerAddress("localhost", 27017);
            adds.add(serverAddress);

            List<MongoCredential> credentials = new ArrayList<>();
            //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
            MongoCredential mongoCredential = MongoCredential.createScramSha1Credential("username", "databaseName", "password".toCharArray());
            credentials.add(mongoCredential);

            //通过连接认证获取MongoDB连接
            mongoClient = new MongoClient(adds, credentials);*/
            return mongoClient;
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
