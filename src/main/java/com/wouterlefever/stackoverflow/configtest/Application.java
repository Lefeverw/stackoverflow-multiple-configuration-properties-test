package com.wouterlefever.stackoverflow.configtest;

import com.wouterlefever.stackoverflow.configtest.config.MyConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
    private final MyConfig myConfig;

    public Application(MyConfig myConfig) {
        this.myConfig = myConfig;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(myConfig.getProperties());
    }
}
