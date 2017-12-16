package com.agilebis.test.assessmentDemo.config;


import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

@Component
@Configuration
@ConfigurationProperties("spring.datasource")
public class CustomBean {

	@Autowired
	DataSourceConfiguration dataSource;

	@Value("classpath:ouath-mysql-schema.sql")
	private Resource mySQLSchemaScript;

	@PostConstruct
	public void dataSourceInitializer() throws Exception {
		final DataSourceInitializer initializer = new DataSourceInitializer();
		initializer.setDataSource(dataSource.getDataSource());
		initializer.setDatabasePopulator(databasePopulator());
		initializer.setEnabled(dataSource.isPreRunOauth2Schema());
		initializer.afterPropertiesSet();
	}

	private DatabasePopulator databasePopulator() {
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		if (dataSource.getDriverClassName().contains("mysql")) 
			populator.addScript(mySQLSchemaScript);
		return populator;
	}

}

