package com.tedu.web.backend;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.tedu.utils.JDBCU;
import com.tedu.utils.MongoDBUtil;
import org.bson.Document;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet(name = "Servlet",urlPatterns = "/Servlete")
public class Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0.处理post乱码
        request.setCharacterEncoding("utf-8");

        //1.获取请求参数
        String name = request.getParameter("name");
        String zl = request.getParameter("zl");
        if(zl.equals("sjsm")) {
            zl="手机数码";
        }else if(zl.equals("qc")) {
            zl="汽车";
        }
        double dj = Double.parseDouble(request.getParameter("danjia"));
        int kc = Integer.parseInt(request.getParameter("kc"));
        String desc = request.getParameter("desc");

        //2.把数据保存到数据库中
        add(name,zl,dj,kc,desc);

        //3.提示用户添加成功
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write("<h1 style='color:green;margin:5px 15px;'>");
        writer.write("添加成功...");
        writer.write("</h1>");

        //4.跳转到商品列表
        response.setHeader("Refresh", "3;url="+request.getContextPath()+"/backend/add.jsp");

    }

    private void add(String name, String zl, double dj, int kc, String desc) {
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            //1.获取数据库连接
            conn = JDBCU.getConnection();
            //2.声明SQL语句
            String sql="insert into product values(null,?,?,?,?,?)";
            //3.获取传输器
            ps=conn.prepareStatement(sql);
            //4.设置SQL参数
            ps.setString(1, name);
            ps.setString(2, zl);
            ps.setDouble(3, dj);
            ps.setInt(4, kc);
            ps.setString(5, desc);

            //5.执行SQL语句
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("商品添加失败");
        }finally {
            JDBCU.closes(null, ps, conn);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
