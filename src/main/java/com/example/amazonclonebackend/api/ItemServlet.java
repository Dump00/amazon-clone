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
        try (Connection connection = dataSource.getConnection()) {
            Jsonb jsonb = JsonbBuilder.create();
            ItemService itemService = new ItemService(connection);
            String code = req.getParameter("code");
            resp.setContentType("application/json");
            if (code != null){
                ItemDTO item = itemService.getItem(code);
                if (item != null){
                    resp.getWriter().println(jsonb.toJson(item));
                }else{
                    resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                }
            }else{
                List<ItemDTO> items = itemService.getAllItems();
                resp.getWriter().println(jsonb.toJson(items));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Failed to obtain a new connection ", ex);
        }
    }

    public void destroy() {
    }
}