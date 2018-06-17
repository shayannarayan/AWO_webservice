package com.awo.app.service.registration;

import java.util.List;

import com.awo.app.domain.login.Authentication;
import com.awo.app.domain.registration.Registration;
import com.awo.app.model.address.AddrModel;
import com.awo.app.model.registration.RegAdr;
import com.awo.app.model.registration.RegistrationModel;
import com.awo.app.response.Response;

public interface RegService {

	Response saveReg(RegistrationModel model);

	List<AddrModel> getDetailsByAreaAndPincode(String area, String pincode);
	
	Response deleteById(String regId);
	
	Registration getDetailsById(String regId);

	Authentication authenticate(RegistrationModel model) throws Exception;

	List<RegistrationModel> getUsers() throws Exception;

	RegAdr getById(String regId);

}
