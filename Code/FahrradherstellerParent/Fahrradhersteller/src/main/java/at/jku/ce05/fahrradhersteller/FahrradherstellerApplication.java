package at.jku.ce05.fahrradhersteller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class FahrradherstellerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FahrradherstellerApplication.class, args);
	}

}
