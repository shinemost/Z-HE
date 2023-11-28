package com.service;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class HBaseService {

    @Autowired
    private Connection hbaseConnection;

    public void putHBaseData() throws IOException {
        Table table = hbaseConnection.getTable(TableName.valueOf("mytable"));
        Put put = new Put(Bytes.toBytes("myrow"));
        put.addColumn(Bytes.toBytes("mycf"), Bytes.toBytes("mycolumn"), Bytes.toBytes("myvalue"));
        table.put(put);
        table.close();
    }

    public String getHBaseData() throws IOException {
        Table table = hbaseConnection.getTable(TableName.valueOf("mytable"));
        Get get = new Get(Bytes.toBytes("myrow"));
        Result result = table.get(get);
        byte[] valueBytes = result.getValue(Bytes.toBytes("mycf"), Bytes.toBytes("mycolumn"));
        String value = Bytes.toString(valueBytes);
        table.close();
        return value;
    }
}
