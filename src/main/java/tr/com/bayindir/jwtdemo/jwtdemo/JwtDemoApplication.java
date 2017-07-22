package tr.com.bayindir.jwtdemo.jwtdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import tr.com.bayindir.jwtdemo.jwtdemo.security.SecurityFilter;

@SpringBootApplication
public class JwtDemoApplication {
	@Bean
	public FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new SecurityFilter());
		registrationBean.addUrlPatterns("/api/*");
		return registrationBean;
	}

	public static void main(String[] args) {
		SpringApplication.run(JwtDemoApplication.class, args);
	}
}
