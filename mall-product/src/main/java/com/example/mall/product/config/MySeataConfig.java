package com.example.mall.product.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;

/**
 * This is description.
 *
 * @author Chris0710
 * @Email chrisleejing0710@gmail.com
 */
// @Configuration
// public class MySeataConfig {
//
//     @Autowired
//     DataSourceProperties dataSourceProperties;
//
//
//     @Bean
//     public DataSource dataSource(DataSourceProperties dataSourceProperties) {
//
//         HikariDataSource dataSource = dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
//         if (StringUtils.hasText(dataSourceProperties.getName())) {
//             dataSource.setPoolName(dataSourceProperties.getName());
//         }
//
//         return new DataSourceProxy(dataSource);
//     }
//
// }

