package com.example.SessionState;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.geode.config.annotation.EnableClusterAware;
import org.springframework.session.data.gemfire.config.annotation.web.http.EnableGemFireHttpSession;
import org.springframework.session.data.gemfire.expiration.SessionExpirationPolicy;

@SpringBootApplication
@EnableClusterAware
@EnableGemFireHttpSession(
    maxInactiveIntervalInSeconds = 300,
    sessionExpirationPolicyBeanName = "expirationPolicy"
)
public class SessionStateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SessionStateApplication.class, args);
	}

	@Bean
    SessionExpirationPolicy expirationPolicy() {
        return new MySessionExpirationPolicy();
    }
}
