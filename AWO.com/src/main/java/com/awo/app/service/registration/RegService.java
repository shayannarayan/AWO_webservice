package com.awo.app.service.registration;

import java.util.List;

import com.awo.app.model.login.LoginModel;
import com.awo.app.model.registration.RegistrationModel;
import com.awo.app.response.Response;

public interface RegService {

	Response saveReg(RegistrationModel model);

	RegistrationModel getById(int regId);

	Response deleteById(int regId);

	LoginModel authenticate(LoginModel model) throws Exception;

	List<RegistrationModel> getUsers() throws Exception;

}
