package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MyHBaseService {

    @Autowired
    private HBaseService hbaseService;

    public void insertData() throws IOException {
        hbaseService.putHBaseData();
    }

    public String getData() throws IOException {
        return hbaseService.getHBaseData();
    }

}
