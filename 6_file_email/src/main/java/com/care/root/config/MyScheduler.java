package com.care.root.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class MyScheduler {
	
	@Scheduled(cron = "*/10 * * * * *")
	public void test1() {
		System.out.println("==== 10초에 한번 ====");
		
	}
	
	@Scheduled(cron = "0-59 * * * * *")
	public void test2() {
		System.out.println("==== 매초마다 ====");
		
	}
}
