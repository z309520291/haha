package com.itheima.dao.conf;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.itheima")
@Import(conf_datasource.class)
public class Conf {
    @Bean(name = "runner")
    public QueryRunner createQueryRunner(@Qualifier("ds")DataSource dataSource){
        return new QueryRunner(dataSource);
    }


}
