package com.company.greenspaceproject;

import com.company.greenspaceproject.entity.UserLogin;
import com.company.greenspaceproject.service.IUserService;
import com.company.greenspaceproject.service.impl.UserServiceImpl;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class GreenSpaceProjectApplicationTests {
    @Autowired
    DataSource dataSource;
    @Autowired
    IUserService iUserService;

    @Test
    void contextLoads() throws SQLException {
        /**
         * test mybatis data access
         */
        System.out.println("The connected database is:"+dataSource.getConnection());
        UserLogin userLogin = iUserService.login("zhangsan@gmail.com", "zhangsan");
        System.out.println(userLogin.toString());
    }

}
