package com.example.amazonclonebackend.service;

import java.sql.Connection;

public class OrderService {
    private Connection connection;

    public OrderService(Connection connection){
        this.connection = connection;
    }

    public void placeOrder(){

    }
}
