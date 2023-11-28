package com;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.service.MyHBaseService;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

@SpringBootTest(classes = ZHeApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
class ZHeApplicationTests {

    @Autowired
    private MyHBaseService hbaseService;

    @Test
    public void testPutAndGetHBaseData() throws IOException {
        // 插入数据
        hbaseService.insertData();

        // 读取数据
        String value = hbaseService.getData();
        assertEquals("myvalue", value);
    }

}
