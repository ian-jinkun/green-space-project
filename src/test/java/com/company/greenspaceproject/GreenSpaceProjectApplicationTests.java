package com.company.greenspaceproject;

import com.company.greenspaceproject.entity.UserLogin;
import com.company.greenspaceproject.service.IUserService;
import com.company.greenspaceproject.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GreenSpaceProjectApplicationTests {

    @Test
    void contextLoads() {
        /**
         * test mybatis data access
         */
        IUserService test = new UserServiceImpl();
        UserLogin userLogin = test.login("zhangsan@gmail.com", "zhangsan");
        userLogin.toString();
    }

}
