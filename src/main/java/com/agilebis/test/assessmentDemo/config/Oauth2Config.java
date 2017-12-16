package com.agilebis.test.assessmentDemo.config;

import static com.agilebis.test.assessmentDemo.utility.Constants.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

@Configuration
@EnableAuthorizationServer
public class Oauth2Config extends AuthorizationServerConfigurerAdapter{
	
	@Autowired
	Environment environment;
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	DataSourceConfiguration customDataSource;
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer configurer) throws Exception {
		configurer.userDetailsService(userDetailsService);		
		configurer.tokenStore(tokenStore()).authenticationManager(authenticationManager).approvalStoreDisabled();
	}
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
				.withClient(environment.getProperty(OAUTH2_CLIENT_CLIENT_ID))
				.secret(environment.getProperty(OAUTH2_CLIENT_CLIENT_SECRET))
				.authorizedGrantTypes(AUTHORIZATION_CODE, REFRESH_TOKEN, PASSWORD)
				.scopes(environment.getProperty(OAUTH2_CLIENT_SCOPE))
				.accessTokenValiditySeconds(Integer.parseInt(environment.getProperty(OAUTH2_ACCESS_TOKEN_VALIDITY_SECONDS)))
				.refreshTokenValiditySeconds(Integer.parseInt(environment.getProperty(OAUTH2_REFRESH_TOKEN_VALIDITY_SECONDS)))
				.autoApprove(true);
	}
	
	@Bean
	public TokenStore tokenStore() {
		return new JdbcTokenStore(customDataSource.getDataSource());
	}
	
}
