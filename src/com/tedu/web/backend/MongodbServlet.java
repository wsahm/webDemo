package com.tedu.web.backend;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.tedu.utils.MongoDBUtil;
import org.bson.Document;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MongodbServlet",urlPatterns = "/MongodbServlet")
public class MongodbServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        try{
            MongoDatabase mongoDatabase = MongoDBUtil.getConnect();
            MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("product");
            Document document = new Document("name","张三")
                    .append("sex", "男")
                    .append("age", 18);
            mongoCollection.insertOne(document);
            response.getWriter().write("人员添加成功");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("人员添加失败");
        }finally {

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
