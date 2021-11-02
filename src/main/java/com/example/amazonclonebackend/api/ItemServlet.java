package com.example.amazonclonebackend.api;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.sql.DataSource;

@WebServlet(name = "helloServlet", value = "/items", loadOnStartup = 0)
public class ItemServlet extends HttpServlet {

    @Resource(name = "java:comp/env/jdbc/amazon")
    private DataSource dataSource;

    public void init() {
        try{
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
    }

    public void destroy() {
    }
}