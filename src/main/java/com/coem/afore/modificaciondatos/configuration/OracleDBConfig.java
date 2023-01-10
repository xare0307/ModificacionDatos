package com.coem.afore.modificaciondatos.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;


public class OracleDBConfig {
	
	private JdbcTemplate jdbcTemplate;
	
	public OracleDBConfig(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
