package com.example.amazonclonebackend.service;

import com.example.amazonclonebackend.dto.OrderDetailDTO;

import java.sql.Connection;
import java.util.List;

public class OrderService {
    private Connection connection;

    public OrderService(Connection connection){
        this.connection = connection;
    }

    public void placeOrder(List<OrderDetailDTO> orderDetails){

    }
}
