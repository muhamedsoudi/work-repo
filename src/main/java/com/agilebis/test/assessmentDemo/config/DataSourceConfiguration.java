package com.agilebis.test.assessmentDemo.config;

import javax.annotation.PostConstruct;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
@ConfigurationProperties("spring.datasource")
public class DataSourceConfiguration {

	private String url;
	private String username;
	private String password;
	private String driverClassName;
	private boolean testOnBorrow;
	private String validationQuery;
	private boolean preRunOauth2Schema;
	private DataSource dataSource;

	@Bean
	@PostConstruct
	public DataSource dataSource() {
		dataSource = (DataSource) DataSourceBuilder.create().url(url).username(username).password(password).driverClassName(driverClassName).build();
		dataSource.setTestOnBorrow(testOnBorrow);
		dataSource.setValidationQuery(validationQuery);
		dataSource.setMinIdle(1);
		dataSource.setMaxIdle(5);
		dataSource.setTestWhileIdle(true);
		dataSource.setTimeBetweenEvictionRunsMillis(5000);
		dataSource.setMinEvictableIdleTimeMillis(60000);
		return dataSource;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public boolean isTestOnBorrow() {
		return testOnBorrow;
	}

	public void setTestOnBorrow(boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}

	public String getValidationQuery() {
		return validationQuery;
	}

	public void setValidationQuery(String validationQuery) {
		this.validationQuery = validationQuery;
	}

	public boolean isPreRunOauth2Schema() {
		return preRunOauth2Schema;
	}

	public void setPreRunOauth2Schema(boolean preRunOauth2Schema) {
		this.preRunOauth2Schema = preRunOauth2Schema;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
