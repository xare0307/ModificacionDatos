package com.coem.afore.modificaciondatos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
@EnableFeignClients
public class TaskServiceHuellasApplication  /*implements CommandLineRunner */{

	public static void main(String[] args) {
		SpringApplication.run(TaskServiceHuellasApplication.class, args);
	}

//	@Autowired
//	JdbcTemplate jdbcTemplate; 
//	
//	
//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		String query = "SELECT COUNT(*) FROM ADMINISTRATOR.TA_CATALOGO_SUCURSALES ";
//		Integer count =  jdbcTemplate.queryForObject(query, Integer.class, null);
//		System.out.println("count "+ count);
//		
//		
//	}

}
