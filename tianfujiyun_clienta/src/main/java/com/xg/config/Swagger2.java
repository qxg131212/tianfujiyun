package com.xg.config;

import com.google.common.base.Predicate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@ConfigurationProperties(prefix = "swagger")
public class Swagger2 {
    private  boolean disable;
    //访问地址：http://localhost:8001/swagger-ui.html

    @Bean
    public Docket creatRestApi(){
        Predicate selector =  PathSelectors.any();
        if (disable){
            selector  = PathSelectors.none();
        }
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())

                .select()

                //项目地址
                .apis(RequestHandlerSelectors.basePackage("com.xg"))
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))                         //这里采用包含注解的方式来确定要显示的接口
//                .apis(RequestHandlerSelectors.basePackage("cn.stylefeng.guns.modular.system.controller"))     //这里采用包扫描的方式来确定要显示的接口

                .paths(selector)

                .build();
    }
    private ApiInfo apiInfo() {

        return new ApiInfoBuilder()

                .title("工具接口")

                .description("boot Api文档")

                .version("1.0.0.")

                .build();

    }

    public void setDisable(boolean disable) {

        this.disable = disable;

    }
}
