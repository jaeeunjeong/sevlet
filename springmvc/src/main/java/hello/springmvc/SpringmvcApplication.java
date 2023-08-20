package hello.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringmvcApplication {

	public static void main(String[] args) {
		System.out.println("SpringmvcApplication.main");
		SpringApplication.run(SpringmvcApplication.class, args);
	}

}
