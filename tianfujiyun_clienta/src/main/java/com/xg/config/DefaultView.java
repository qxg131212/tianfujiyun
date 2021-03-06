package com.xg.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class DefaultView extends WebMvcConfigurerAdapter {

    @Override  //首页面的问题，暂无处理好
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/templates").setViewName("forward:index.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }
}
