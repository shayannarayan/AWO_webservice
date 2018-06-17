package com.awo.app.service.registration;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awo.app.controller.image.ImgController;
import com.awo.app.dao.address.AddrDaoImp;
import com.awo.app.dao.registration.RegDao;
import com.awo.app.domain.address.Address;
import com.awo.app.domain.login.Authentication;
import com.awo.app.domain.registration.Registration;
import com.awo.app.mapper.address.AddressMapper;
import com.awo.app.mapper.registration.RegistrationMapper;
import com.awo.app.model.address.AddrModel;
import com.awo.app.model.registration.RegAdr;
import com.awo.app.model.registration.RegistrationModel;
import com.awo.app.response.ErrorObject;
import com.awo.app.response.Response;
import com.awo.app.servicee.address.AddrService;
import com.awo.app.utils.CommonUtils;
import com.awo.app.utils.DateUtility;

@Service
public class RegServiceImp implements RegService {

	private static final Logger logger = LoggerFactory.getLogger(RegServiceImp.class);

	@Autowired
	ImgController imgController;

	@Autowired
	private AddrDaoImp addrDaoImp;

	@Autowired
	private RegDao regDao;

	@Autowired
	private RegistrationMapper registrationMapper;

	@Autowired
	private AddressMapper addressMapper;

	@Autowired
	private AddrService addrService;


	@Override
	public Response saveReg(RegistrationModel model) {
		Response res = new Response();
		try {
			Registration reg = new Registration();
			BeanUtils.copyProperties(model, reg);
			reg.setRegId(CommonUtils.generateRandomId());
			reg.setActive(true);
		// reg.setEnterPassword(CommonUtils.encriptString(reg.getEnterPassword()));
			reg.setDob(DateUtility.getDateByStringFormat(new Date(), DateUtility.DATE_FORMAT_MM_DD_YYYY));
			reg.setDob(model.getDob());
			reg.setIma_iba(model.getIma_iba());

			Address addr = new Address();
			addr.setAddressId(CommonUtils.generateRandomId());
			addr.setArea(model.getArea());
			addr.setCity(model.getCity());
			addr.setEmailId(model.getEmailId());
			addr.setState(model.getState());
			addr.setStreet(model.getStreet());
			addr.setWebsite(model.getWebsite());
			addr.setMobile(model.getMobile());
			addr.setPhone(model.getPhone());
			addr.setPincode(model.getPincode());
			addr.setDateAndTime(
					DateUtility.getDateByStringFormat(new Date(), DateUtility.DATE_FORMAT_DD_MM_YYYY_HHMMSS));
			addr.setModifiedDateAndTime(
					DateUtility.getDateByStringFormat(new Date(), DateUtility.DATE_FORMAT_DD_MM_YYYY_HHMMSS));
			addr.setActive(true);
			addr.setRegistration(reg);
			reg.getAddress().add(addr);
			
			Authentication auth = new Authentication();
			auth.setAuthId(CommonUtils.generateRandomId());
			auth.setUserName(model.getUserName());
			auth.setPassword(CommonUtils.encriptString(model.getPassword()));
			auth.setHint(model.getHint());
			auth.setRegistration(reg);
			reg.setAuthentication(auth);
			
			/*Image img = new Image();
			if(file!=null) {
				
				img.setImgId(CommonUtils.generateRandomId());
				img.setImgName(file.getName());
				img.setType(file.getContentType());
				img.setRegistration(reg);
				img.setCreatedDate(DateUtility.getDateByStringFormat(new Date(), DateUtility.DATE_FORMAT_DD_MM_YYYY_HHMMSS));
				img.setModifiedDate(DateUtility.getDateByStringFormat(new Date(), DateUtility.DATE_FORMAT_DD_MM_YYYY_HHMMSS));
				img.setPic(file.getBytes());
				System.out.println(file.getName());
				reg.setImage(img);
			}*/

			res = regDao.saveReg(reg);

			return res;
		} catch (Exception e) {
			logger.info("Exception in add User :" + e.getMessage());
			ErrorObject err = CommonUtils.getErrorResponse("Exception", "Exception in add UserDetails");
			res.setErrors(err);
			res.setMessage(e.getMessage());
			return res;
		}

	}

	@Override
	public List<AddrModel> getDetailsByAreaAndPincode(String area,String pincode) {
		try {
			List<Address> adr = regDao.getDetailsByAreaAndPincode(area, pincode);
//			String img = imgController.getImg(regId);
			List<AddrModel> list = addressMapper.entityList(adr);
			
			 return list;
		} catch (Exception e) {
			logger.info("Exception in get User/Donor Details :" + e.getMessage());
			return null;
		}

	}
	
	@Override
	public Registration getDetailsById(String regId) {
		try {
			Registration reg = regDao.getDetailsById(regId);
			return reg;
		} catch (Exception e) {
			logger.info("Exception in get User/Donor Details :" + e.getMessage());
			return null;
		}

	}

	@Override
	public RegAdr getById(String regId) {
		try {
			Registration reg = regDao.getDetailsById(regId);
			// List<AddrModel> adr = addrService.getByAddressesId(regId);
			RegAdr model = new RegAdr();
			model.setFirstName(reg.getFirstName());
			model.setMiddleName(reg.getMiddleName());
			model.setLastName(reg.getLastName());
			model.setDob(reg.getDob());
			model.setBloodGroup(reg.getBloodGroup());
			model.setAge(reg.getAge());
			model.setGender(reg.getGender());
			
			
			return model;
		} catch (Exception e) {
			logger.info("Exception in get User/Donor Details :" + e.getMessage());
			return null;
		}

	}

	@Override
	public Response deleteById(String regId) {
		try {
//			Response res = addrDaoImp.deleteAddress(regId);

			Response res = regDao.deleteById(regId);
			
			return res;
		} catch (Exception e) {
			logger.info("Exception in DeleteById :" + e.getMessage());
			return null;
		}

	}

	@Override
	public Authentication authenticate(RegistrationModel model) throws Exception {
		model.setPassword(CommonUtils.encriptString(model.getPassword()));
		Authentication reg = new Authentication();
		BeanUtils.copyProperties(model, reg);
//		LoginModel log =new LoginModel();
		reg = regDao.authenticate(reg);
//		BeanUtils.copyProperties(reg, log);
//		 String img = imgController.getImg(reg.getRegistration());
		if (reg == null) {
			return null;
		} else {
			
		/*	model.setFirstName(reg.getFirstName());
			model.setMiddleName(reg.getMiddleName());
			model.setLastName(reg.getLastName());
			model.setDob(reg.getDob());
			model.setBloodGroup(reg.getBloodGroup());
			model.setAge(reg.getAge());
			model.setGender(reg.getGender());
			
			 model.setStreet(reg.getStreet()); model.setArea(reg.getArea());
			 model.setCity(reg.getCity()); model.setPincode(reg.getPincode());
			 model.setPhoneNumber(reg.getPhoneNumber());
			 model.setEmailId(reg.getEmailId()); model.setBloodGroup(reg.getBloodGroup());
			 model.setDonatedBloodRecently(reg.getDonatedBloodRecently());
			 
			model.setEnterPassword("*********");
			// model.setUrl(img.toString());
*/			
			return reg;
		}
	}

	@Override
	public List<RegistrationModel> getUsers() {
		try {
			List<Registration> users = regDao.getUsers();

			return registrationMapper.entityList(users);
		} catch (Exception e) {
			logger.error("Exception getUsers:" + e.getMessage());
			return null;
		}

	}

}
