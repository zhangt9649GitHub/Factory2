package com.mingyuansoftware.aifactory;


import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.MultipartConfigElement;
import java.io.File;


/**
 * @program: swagger2-API
 * @description: swagger2配置类
 * @author: Bacy
 * @create: 2018年12月17日
 **/
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())//调用下面apiInfo()方法
                .select()
                //Controller所在路径
                .apis(RequestHandlerSelectors.basePackage("com.mingyuansoftware.aifactory"))
                .paths(PathSelectors.any())
                .build();

    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("乐志明康智慧工厂项目 API")
                .description("API接口文档")
                .termsOfServiceUrl("http://112.126.98.72/swagger-ui.html#/")
                .contact("ht")
                .version("0.0.1")
                .build();

    }

    //启动类中加入配置临时文件目录 临时文件地址无效
    // 解决 The temporary upload location [/tmp/tomcat.2737591724424319502.8062/work/Tomcat/localhost/ROOT] is not valid
    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        String location = System.getProperty("user.dir") + "/data/tmp";
        File tmpFile = new File(location);
        if (!tmpFile.exists()) {
            tmpFile.mkdirs();
        }
        factory.setLocation(location);
        return factory.createMultipartConfig();
    }

    /**
     * 解决异常信息：
     *  java.lang.IllegalArgumentException:
     *      Invalid character found in the request target. The valid characters are defined in RFC 7230 and RFC 3986
     *       说明:
     *       SpringBoot 2.0.0 以上都采用内置tomcat8.0以上版本，而tomcat8.0以上版本遵从RFC规范添加了对Url的特殊字符的限制，url中只允
     *       许包含英文字母(a-zA-Z)、数字(0-9)、-_.~四个特殊字符以及保留字符( ! * ’ ( ) ; : @ & = + $ , / ? # [ ] ) (26*2+10+4+18=84)这84个字符,
     *       请求中出现了{}大括号或者[],所以tomcat报错。设置RelaxedQueryChars允许此字符(建议)，设置requestTargetAllows选项(Tomcat 8.5中不推荐)。
     *       您可以降级为旧版本之一(不推荐-安全性)。根据 https://tomcat.apache.org/tomcat-8.5-doc/config/systemprops.html,
     *       requestTargetAllowis设置允许不受欢迎字符。对我来说，这里提出的其他解决办法也不起作用。根据Tomcat文档，我找到了一种方法来设置松弛的QueryChars属性
     * @return
     */
    @Bean
    public ConfigurableServletWebServerFactory webServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
            @Override
            public void customize(Connector connector) {
                connector.setProperty("relaxedQueryChars", "[]|{}?\\");
            }
        });
        return factory;
    }

}
