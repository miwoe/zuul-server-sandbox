package de.miwoe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@SpringBootApplication
//@EnableAutoConfiguration
@EnableDiscoveryClient
public class WebappApplication {


	@Bean
	public Filter getLogFilter() {
		return new OncePerRequestFilter() {
			@Override
			protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

				Enumeration<String> enumHeaders = httpServletRequest.getHeaderNames();
				while (enumHeaders.hasMoreElements()) {
					String header = enumHeaders.nextElement();
					System.out.println(header + ": " + httpServletRequest.getHeader(header));
				}
				filterChain.doFilter(httpServletRequest, httpServletResponse);

			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(WebappApplication.class, args);
	}
}
