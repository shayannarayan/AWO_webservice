package com.awo.app.service.registration;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awo.app.controller.image.ImgController;
import com.awo.app.dao.registration.RegDao;
import com.awo.app.domain.registration.Registration;
import com.awo.app.mapper.registration.RegistrationMapper;
import com.awo.app.model.image.ModelImg;
import com.awo.app.model.login.LoginModel;
import com.awo.app.model.registration.RegistrationModel;
import com.awo.app.response.ErrorObject;
import com.awo.app.response.Response;
import com.awo.app.utils.CommonUtils;
import com.awo.app.utils.DateUtility;



@Service
public class RegServiceImp implements RegService{
	
	private static final Logger logger = LoggerFactory.getLogger(RegServiceImp.class);
	
	@Autowired
	ImgController imgController;
	@Autowired
	RegDao regDao;
	
	@Autowired
	RegistrationMapper registrationMapper;

	@Override
	public Response saveReg(RegistrationModel model) {
		Response res = new Response();
		try {
		Registration reg = new Registration();
		BeanUtils.copyProperties(model, reg);
		reg.setEnterPassword(CommonUtils.encriptString(reg.getEnterPassword()));
		reg.setDob(DateUtility.getDateByStringFormat(new Date(),DateUtility.DATE_FORMAT_DD_MM_YYYY));
		res = regDao.saveReg(reg);
		return res;
		}catch(Exception e) {
			logger.info("Exception in add User "+ e.getMessage());
			ErrorObject err = CommonUtils.getErrorResponse("Exception", "Exception in add UserDetails");
			res.setErrors(err);
			res.setMessage(e.getMessage());
			return res;
		}
		
	}

	@Override
	public RegistrationModel getById(int regId) {
		try {
		Registration reg = regDao.getById(regId);
		RegistrationModel model = new RegistrationModel();
		model.setFirstName(reg.getFirstName());
		model.setMiddleName(reg.getMiddleName());
		model.setLastName(reg.getLastName());
		model.setDob(reg.getDob());
		model.setBloodGroup(reg.getBloodGroup());
		model.setAge(reg.getAge());
		model.setGender(reg.getGender());
		model.setStreet(reg.getStreet());
		model.setArea(reg.getArea());
		model.setCity(reg.getCity());
		model.setPincode(reg.getPincode());
		model.setPhoneNumber(reg.getPhoneNumber());
		model.setEmailId(reg.getEmailId());
		model.setBloodGroup(reg.getBloodGroup());
		model.setDonatedBloodRecently(reg.getDonatedBloodRecently());
		return model;
		}catch(Exception e){
			logger.info("Exception in get User/Donor Details :"+e.getMessage());
			return null;
		}
		
	}

	@Override
	public Response deleteById(int regId) {
		try {
			return regDao.deleteById(regId);
		}catch(Exception e) {
			logger.info("Exception in DeleteById :"+e.getMessage());
			return null;
		}
		
	}

	@SuppressWarnings("unused")
	@Override
	public LoginModel authenticate(LoginModel model) throws Exception {
		model.setEnterPassword(CommonUtils.encriptString(model.getEnterPassword()));
		Registration reg = new Registration();
		BeanUtils.copyProperties(model, reg);
		reg = regDao.authenticate(reg);
		String img = imgController.getImg(reg.getRegId());
		if(reg==null){
			return null;
			}else {
			model.setFirstName(reg.getFirstName());
			model.setMiddleName(reg.getMiddleName());
			model.setLastName(reg.getLastName());
			model.setDob(reg.getDob());
			model.setBloodGroup(reg.getBloodGroup());
			model.setAge(reg.getAge());
			model.setGender(reg.getGender());
			model.setStreet(reg.getStreet());
			model.setArea(reg.getArea());
			model.setCity(reg.getCity());
			model.setPincode(reg.getPincode());
			model.setPhoneNumber(reg.getPhoneNumber());
			model.setEmailId(reg.getEmailId());
			model.setBloodGroup(reg.getBloodGroup());
			model.setDonatedBloodRecently(reg.getDonatedBloodRecently());
			model.setEnterPassword("*********");
			model.setUrl(img.toString());
			return model;
		}
	}

	@Override
	public List<RegistrationModel> getUsers() {
		try {
		List<Registration> users = regDao.getUsers();
		
		return registrationMapper.entityList(users);
		}catch(Exception e) {
			logger.error("Exception getUsers:"+ e.getMessage());
			return null;
		}
		
	}

}
