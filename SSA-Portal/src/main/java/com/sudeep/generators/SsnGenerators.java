package com.sudeep.generators;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class SsnGenerators implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		Random random = new Random();
		Long prefix = (long) (random.nextInt(100) + random.nextInt(10));
		Long suffix = 0L;
		try {
			Connection con = session.connection();
			Statement statement = con.createStatement();

			String sql = "select SSN_ID_SEQ.nextval from dual";
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				int seqval = resultSet.getInt(1);
				suffix = (long) seqval;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return prefix + suffix;
	}

	/*
	 * NEXT IMPROVEMENT WILL DO LATER
	 * 
	 * public Map<String, Integer> getAllStates() { Map<String, Integer> countryMap
	 * = new LinkedHashMap<String, Integer>();
	 * 
	 * List<StateEntity> statesList = stateRepository.findAll();
	 * 
	 * countryMap =
	 * statesList.stream().collect(Collectors.toMap(StateEntity::getStateName,
	 * StateEntity::getAreaCode));
	 * 
	 * return countryMap;
	 * 
	 * }
	 */
}
