package com.config;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class HbaseConfig {

    @Value("${spring.hbase.zookeeper.quorum}")
    private String zookeeperQuorum;

    @Value("${spring.hbase.client.port}")
    private String hbaseClientPort;

    @Bean
    public Connection hbaseConnection() throws IOException {
        org.apache.hadoop.conf.Configuration config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.quorum", zookeeperQuorum);
        config.set("hbase.client.port", hbaseClientPort);
        return ConnectionFactory.createConnection(config);
    }
}
