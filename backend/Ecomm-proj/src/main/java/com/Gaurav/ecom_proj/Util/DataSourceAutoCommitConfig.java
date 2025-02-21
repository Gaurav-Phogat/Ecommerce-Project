package com.Gaurav.ecom_proj.Util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceUtils;
import javax.sql.DataSource;

@Configuration
public class DataSourceAutoCommitConfig implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof DataSource) {
            try {
                DataSourceUtils.getConnection((DataSource) bean).setAutoCommit(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return bean;
    }
}


