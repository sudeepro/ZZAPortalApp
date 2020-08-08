package com.sudeep.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudeep.entity.SsnEntity;
import com.sudeep.model.UserSsn;
import com.sudeep.repository.SsnRepository;
import com.sudeep.repository.StateRepository;

@Service
public class SsnServiceImpl implements SsnService {

	@Autowired
	private SsnRepository ssnRepository;
	@Autowired
	private StateRepository stateRepository;

	@Override
	public UserSsn saveUser(UserSsn user) {
		SsnEntity entity = new SsnEntity();
		if (user != null) {
			BeanUtils.copyProperties(user, entity);

			/*
			 * Integer theAreaCode = getAllStates().get(user.getState()); String newSsnId =
			 * String.valueOf(theAreaCode) + "-" + RandomStringUtils.randomNumeric(2) + "-"
			 * + RandomStringUtils.randomNumeric(4);
			 */
			ssnRepository.save(entity);
		}
		return user;
	}

	/*
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
	 */

	public List<String> retriveStates() {

		return stateRepository.findAllState();

	}

	@Override
	public Boolean findSsn(Long ssnId) {
		Optional<SsnEntity> ssn = ssnRepository.findById(ssnId);
		if (ssn.isPresent()) {
			return true;
		} else {
			return false;
		}

	}
}
