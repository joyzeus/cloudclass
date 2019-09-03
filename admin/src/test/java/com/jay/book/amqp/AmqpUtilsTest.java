package com.jay.book.amqp;


import com.jay.book.ApplicationTests;
import com.jay.book.admin.util.amqp.AmqpUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AmqpUtilsTest extends ApplicationTests {

    @Autowired
    private AmqpUtil amqpUtil;

    @Test
    public void testAmqp(){
        amqpUtil.send();
    }
}
