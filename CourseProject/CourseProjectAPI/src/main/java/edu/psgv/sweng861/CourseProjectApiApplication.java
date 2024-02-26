package edu.psgv.sweng861;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.psgv.sweng861.controller.CustomerController;

/** Starts the Spring Boot App.
 * @author Maria Alcantara
*/
@SpringBootApplication
public class CourseProjectApiApplication {

	public static void main(String[] args) {
		System.out.println("Logger name: " + CustomerController.Logger.getName());
		CustomerController.Logger.debug("Application Started");
		SpringApplication.run(CourseProjectApiApplication.class, args);
		CustomerController.Logger.debug("Application Finished");
	}

}
