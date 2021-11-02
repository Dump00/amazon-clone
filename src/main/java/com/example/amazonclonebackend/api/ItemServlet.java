package com.example.amazonclonebackend.api;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.example.amazonclonebackend.dto.ItemDTO;
import com.example.amazonclonebackend.service.ItemService;
import jakarta.annotation.Resource;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
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
        try(Connection connection = dataSource.getConnection()){
            ItemService itemService = new ItemService(connection);
            List<ItemDTO> items = itemService.getAllItems();
            Jsonb jsonb = JsonbBuilder.create();
            resp.setContentType("application/json");
            resp.getWriter().println(jsonb.toJson(items));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to obtain a new connection");
        }
    }

    public void destroy() {
    }
}