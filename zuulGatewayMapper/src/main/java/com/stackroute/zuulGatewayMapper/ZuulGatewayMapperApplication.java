package com.stackroute.zuulGatewayMapper;

import com.stackroute.zuulGatewayMapper.filters.ErrorFilter;
import com.stackroute.zuulGatewayMapper.filters.PostFilter;
import com.stackroute.zuulGatewayMapper.filters.PreFilter;
import com.stackroute.zuulGatewayMapper.filters.RouteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class ZuulGatewayMapperApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulGatewayMapperApplication.class, args);
	}


	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}
	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}
	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}
	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}


}
