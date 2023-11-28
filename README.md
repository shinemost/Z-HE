# Z-HE
基于Elasticsearch+hbase的海量数据查询、即时推送服务系统

```shell
docker run -p 6379:6379 --name redis -d redis:7.0.12  --requirepass admin

docker run -d -h base-server \                                 
        -p 2181:2181  \
        -p 8080:8080  \
        -p 8085:8085  \
        -p 9090:9090  \
        -p 9000:9000  \
        -p 9095:9095  \
        -p 16000:16000  \
        -p 16010:16010  \
        -p 16201:16201  \
        -p 16301:16301  \
        -p 16020:16020 \
        --name hbase  \
        harisekhon/hbase
        
docker network create esvsch
docker-compose up -d

## kibana控制台
kibana: http://localhost:5601

## hbase控制台
http://localhost:16010/master-status

## hbase 建表
docker exec -it hbase bash
hbase shell
create 'article', 'info'

## 搜索页面
http://localhost:8081/Z-HE

## 增加 commons-compress依赖
<dependency>
  <groupId>org.apache.commons</groupId>
  <artifactId>commons-compress</artifactId>
  <version>1.21</version>
</dependency>
```
