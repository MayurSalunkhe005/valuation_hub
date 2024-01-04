package com.valuation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.valuation.emailservice.EmailService;
import com.valuation.security.config.ApplicationConfig;
import com.valuation.security.config.SecurityConfiguration;

@SpringBootApplication
//(exclude = { SecurityConfiguration.class})
public class ValuationHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(ValuationHubApplication.class, args);
	}
    
	@Autowired
	EmailService emailService;
	
	@EventListener(ApplicationReadyEvent.class)
	public void sendMail() {
		emailService.sendEmail("10010mayu@gmail.com", "how are you", "Hello");
	}
	
//	@Bean
//	public CommandLineRunner commandLineRunner(
//			AuthenticationService service
//	) {
//		return args -> {
//			var admin = Register.builder()
//					.firstname("Admin")
//					.lastname("Admin")
//					.email("admin@mail.com")
//					.password("password")
//					.role(ADMIN)
//					.build();
//			System.out.println("Admin token: " + service.register(admin).getToken());
//
//			var manager = Register.builder()
//					.firstname("Admin")
//					.lastname("Admin")
//					.email("manager@mail.com")
//					.password("password")
//					.role(MANAGER)
//					.build();
//			System.out.println("Manager token: " + service.register(manager).getToken());
//
//		};
//	}

}
