package com.coem.afore.modificaciondatos.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.coem.afore.modificaciondatos.configuration.OracleDBConfig;
import com.coem.afore.modificaciondatos.constants.SqlConstants;
import com.coem.afore.modificaciondatos.dao.IUserDao;
import com.coem.afore.modificaciondatos.entity.UserEntity;
import com.coem.afore.modificaciondatos.services.aspect.Profiled;

@Repository
public class UserDaoImpl extends OracleDBConfig implements IUserDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);

	private JdbcTemplate jdbcTemplate;

	public UserDaoImpl(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate);
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public UserEntity getUserId(int id) {
		// TODO Auto-generated method stub
		LOGGER.info("DAO USER init");
		Integer count =  this.jdbcTemplate.queryForObject(SqlConstants.query, Integer.class, null);
		LOGGER.info("Count  {}",count);
		return new UserEntity("test",count) ;
	}

}
