package com.westpacgroup.westpac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class WestpacApplication {

    public static void main(String[] args) {
        SpringApplication.run(WestpacApplication.class, args);
    }

}
