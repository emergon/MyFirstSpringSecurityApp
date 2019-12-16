package com.emergon.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.emergon")
@PropertySource("classpath:database.properties")
public class MyWebMvcConfigurer implements WebMvcConfigurer{

    @Autowired
    private Environment env;
    
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        registry.viewResolver(viewResolver);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String [] paths = {"/static/**"};
        String [] locations = {"/static/"};
        registry.addResourceHandler(paths).addResourceLocations(locations);
    }
    
    @Bean
    public DataSource datasource(){
        ComboPooledDataSource datasource = new ComboPooledDataSource();
        try {
            datasource.setDriverClass(env.getProperty("jdbc.driver"));
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MyWebMvcConfigurer.class.getName()).log(Level.SEVERE, null, ex);
        }
        datasource.setJdbcUrl(env.getProperty("jdbc.url"));
        datasource.setUser(env.getProperty("jdbc.user"));
        datasource.setPassword(env.getProperty("jdbc.password"));
        datasource.setInitialPoolSize(getIntProperty(env.getProperty("connection.pool.initialPoolSize")));
        datasource.setMinPoolSize(getIntProperty(env.getProperty("connection.pool.minPoolSize")));
        datasource.setMaxPoolSize(getIntProperty(env.getProperty("connection.pool.maxPoolSize")));
        datasource.setMaxIdleTime(getIntProperty(env.getProperty("connection.pool.maxIdleTime")));
        return datasource;
    }
    
    private int getIntProperty(String property){
        int value = Integer.parseInt(property);
        return value;
    }
    
}
