package com.awo.app.dao.registration;

import java.util.List;

import com.awo.app.domain.registration.Registration;
import com.awo.app.response.Response;

public interface RegDao {

	

	Response saveReg(Registration reg);

	Registration getById(int regId);

	Response deleteById(int regId);

	Registration authenticate(Registration reg);

	List<Registration> getUsers();

}
