package com.mpc.demo.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseConfiguration {

	// Mysql DataSource Config
	@Bean
    DataSource oraDataSource() throws SQLException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		//MySQL database we are using
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring?autoReconnect=true&useSSL=false");//change url
        dataSource.setUsername("root");//change userid
        dataSource.setPassword("apcl123456");//change pwd
        return dataSource;
    }
	
	
}
