package com.igeek.book.amqp;


import com.igeek.book.ApplicationTests;
import com.igeek.admin.amqp.AmqpUtil;
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
