package project;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import project.httpclient.HttpClient;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws IOException {
		final Logger log = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());
		SpringApplication.run(Application.class, args);
		log.debug("SpringApplicationn is starting");

	}

	
	

}
