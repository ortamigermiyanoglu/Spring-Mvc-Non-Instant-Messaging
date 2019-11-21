package com.sumutella.noninstantmessaging.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author sumutella
 * @time 1:33 PM
 * @since 11/12/2019, Tue
 */


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.sumutella.noninstantmessaging")
@PropertySource("classpath:persistence-oraclejdbc.properties")
public class AppConfiguration implements WebMvcConfigurer {


    @Autowired
    private Environment env;

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver1 = new InternalResourceViewResolver();
        viewResolver1.setPrefix("/WEB-INF/view/");
        viewResolver1.setSuffix(".jsp");
        return viewResolver1;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");

    }


    @Bean
    public DataSource dataSourceLogin() {
        ComboPooledDataSource dataSourceLogin = new ComboPooledDataSource();

        try {
            dataSourceLogin.setDriverClass(env.getProperty("jdbc.driver"));
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }

        dataSourceLogin.setJdbcUrl(env.getProperty("jdbc.url"));
        dataSourceLogin.setUser(env.getProperty("jdbc.user"));
        dataSourceLogin.setPassword(env.getProperty("jdbc.password"));

        dataSourceLogin.setInitialPoolSize(Integer.parseInt(
                env.getProperty("connection.pool.initialPoolSize")));
        dataSourceLogin.setMinPoolSize(Integer.parseInt(
                env.getProperty("connection.pool.minPoolSize")));
        dataSourceLogin.setMaxPoolSize(Integer.parseInt(
                env.getProperty("connection.pool.maxPoolSize")));
        dataSourceLogin.setMaxIdleTime(Integer.parseInt(
                env.getProperty("connection.pool.maxIdleTime")));

        return dataSourceLogin;
    }


}
