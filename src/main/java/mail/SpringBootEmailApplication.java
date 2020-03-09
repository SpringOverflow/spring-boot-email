package mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableScheduling
public class SpringBootEmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmailApplication.class, args);
	}

}

@Component
class Scheduler {
	@Autowired
	JavaMailSender mail;

	@Scheduled(initialDelay = 3000, fixedDelay = 10000)
	private void scheduling() {
		System.out.println("Send Mail...");
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setFrom("ra@techmi.co.in");
		sm.setTo("ra@techmi.co.in");
		sm.setSubject("Test Subjet");
		sm.setText("Body");
		mail.send(sm);
	}
}
