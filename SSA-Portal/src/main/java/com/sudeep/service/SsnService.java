
package com.sudeep.service;

import org.springframework.stereotype.Service;

import com.sudeep.model.UserSsn;

@Service
public interface SsnService {

	public UserSsn saveUser(UserSsn user);

	public Boolean findUser(Long id);

}
