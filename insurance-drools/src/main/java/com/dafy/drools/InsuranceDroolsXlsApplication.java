package com.dafy.drools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.Date;

@Configuration
@SpringBootApplication
public class InsuranceDroolsXlsApplication {

	public static void main(String[] args) {
//		SpringApplication springApplication = new SpringApplication(SpringBootDroolsApplication.class);
//		springApplication.addListeners(new ApplicationPidFileWriter());
//		springApplication.run(args);
//		SpringApplication.run(SpringBootDroolsApplication.class, args);


		System.out.println("InsuranceDroolsXlsApplication start.....");
		ThreadPoolTaskScheduler threadPoolTaskScheduler =new ThreadPoolTaskScheduler();
		threadPoolTaskScheduler.initialize();
		threadPoolTaskScheduler.setPoolSize(1);
		threadPoolTaskScheduler.scheduleAtFixedRate(new Runnable() {
			public void run() {
			}
		},new Date(),60*1000L);
		SpringApplication springApplication=new SpringApplication(InsuranceDroolsXlsApplication.class);
		springApplication.addListeners(new ApplicationPidFileWriter());
		springApplication.run(args);

	}



}
