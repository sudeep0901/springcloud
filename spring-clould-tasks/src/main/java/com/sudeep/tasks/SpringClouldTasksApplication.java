package com.sudeep.tasks;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class SpringClouldTasksApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringClouldTasksApplication.class, args);
	}

	@Bean
	public TollProcessingTask tollProcessingTask() {
		return new TollProcessingTask();
	}

	public class TollProcessingTask implements CommandLineRunner {

		@Override
		public void run(String... strings) throws Exception {
			// TODO Auto-generated method stub
			// station ID, License plate , timestamp

			if (null != strings) {
				System.out.println("parameter lenght is: " + strings.length);

				String stationId = strings[1];
				String licensePlate = strings[2];
				String timestamp = strings[2];

				System.out.println("Station ID: " + stationId + " , License plate is " + licensePlate + "  , timestamp "
						+ timestamp);

//				Scanner sc = new Scanner(System.in);
//				int i = sc.nextInt();
//				System.out.println(i); // will print the variable

			}

		}

	}
}
