package com.netease.thanos.web.springboot.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Arrays;

/**
 * MybatisNvDbConfig.java的实现描述：NbGw数据配置
 * Created by hzliubenlong on 2017/12/7.
 */
@Configuration
@MapperScan(basePackages = {"com.netease.thanos.core.depositChain.repository"}, sqlSessionTemplateRef = "nvSqlSessionTemplate")
public class MybatisNvDbConfig {

    @Resource
    private DruidNvConfig druidNvConfig;

    @Bean(name = "nvDataSource")
    public DataSource nvDataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(druidNvConfig.getUrl());
        datasource.setUsername(druidNvConfig.getUsername());
        datasource.setPassword(druidNvConfig.getPassword());
        datasource.setDriverClassName(druidNvConfig.getDriverClassName());

        //configuration
        datasource.setInitialSize(druidNvConfig.getInitialSize());
        datasource.setMinIdle(druidNvConfig.getMinIdle());
        datasource.setMaxActive(druidNvConfig.getMaxActive());
        datasource.setMaxWait(druidNvConfig.getMaxWait());
        datasource.setTimeBetweenEvictionRunsMillis(druidNvConfig.getTimeBetweenEvictionRunsMillis());
        datasource.setMinEvictableIdleTimeMillis(druidNvConfig.getMinEvictableIdleTimeMillis());
        datasource.setValidationQuery(druidNvConfig.getValidationQuery());
        datasource.setConnectionInitSqls(Arrays.asList(druidNvConfig.getInitConnectionSqls()));
        datasource.setTestWhileIdle(druidNvConfig.isTestWhileIdle());
        datasource.setTestOnBorrow(druidNvConfig.isTestOnBorrow());
        datasource.setTestOnReturn(druidNvConfig.isTestOnReturn());
        datasource.setPoolPreparedStatements(druidNvConfig.isPoolPreparedStatements());
        datasource.setMaxPoolPreparedStatementPerConnectionSize(druidNvConfig.getMaxPoolPreparedStatementPerConnectionSize());
        datasource.setQueryTimeout(druidNvConfig.getQueryTimeout());
        datasource.setValidationQueryTimeout(druidNvConfig.getValidationQueryTimeout());
        datasource.setTransactionQueryTimeout(druidNvConfig.getTransactionQueryTimeout());
        return datasource;
    }

    @Bean(name = "nvTransactionManager")
    public DataSourceTransactionManager nvTransactionManager(@Qualifier("nvDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "nvSqlSessionFactory")
    public SqlSessionFactory nvSqlSessionFactory(@Qualifier("nvDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "nvSqlSessionTemplate")
    public SqlSessionTemplate nvSqlSessionTemplate(@Qualifier("nvSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}