package com.awo.app.dao.registration;

import java.util.List;

import com.awo.app.domain.address.Address;
import com.awo.app.domain.login.Authentication;
import com.awo.app.domain.registration.Registration;
import com.awo.app.response.Response;

public interface RegDao {

	

	Response saveReg(Registration reg);

	List<Address> getDetailsByAreaAndPincode(String area, String pincode);
	
	Registration getDetailsById(String regId);

	Response deleteById(String regId);

	List<Registration> getUsers();

	Authentication authenticate(Authentication reg);

}
