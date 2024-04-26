package com.example.grpcclient;

import com.example.grpcclient.database.UserDao;
import com.example.grpcclient.database.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class GrpcclientApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(GrpcclientApplication.class, args);
        UserDao userDao = new UserDao(ctx.getBean(UserRepository.class));
        userDao.insert1();

    }
}
