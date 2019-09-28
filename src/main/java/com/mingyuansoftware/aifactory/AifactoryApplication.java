package com.mingyuansoftware.aifactory;

import com.mingyuansoftware.aifactory.util.ContextUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@Import(ContextUtils.class)
public class AifactoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(AifactoryApplication.class, args);
    }

}
