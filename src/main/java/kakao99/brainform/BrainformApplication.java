package kakao99.brainform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class BrainformApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrainformApplication.class, args);
	}

}
