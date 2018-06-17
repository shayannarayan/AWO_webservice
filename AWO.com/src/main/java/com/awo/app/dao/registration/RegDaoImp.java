package com.awo.app.dao.registration;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.awo.app.constant.StatusCode;
import com.awo.app.domain.address.Address;
import com.awo.app.domain.login.Authentication;
import com.awo.app.domain.registration.Registration;
import com.awo.app.response.Response;
import com.awo.app.utils.CommonUtils;

@Transactional
@Repository
public class RegDaoImp implements RegDao {

	private static final Logger logger = LoggerFactory.getLogger(RegDaoImp.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Response saveReg(Registration reg) {
		Response res = CommonUtils.getResponseObject("Saved User RegistrationDtails");
		try {
			 entityManager.persist(reg);
			 
		} catch (Exception e) {
			logger.error("Exception in saving RegistrationDetails :" + e.getMessage()	);
		/*	res.setStatus(StatusCode.ERROR.name());
			res.setErrors(e.getMessage());*/
			
		}
		return res;
	}

	@Override
	public List<Address> getDetailsByAreaAndPincode(String area, String pincode) {
		try {
			String hql = "FROM Address WHERE (area=:area OR pincode=:code) AND isActive=true";
			return  entityManager.createQuery(hql).setParameter("area", area).setParameter("code", pincode).getResultList();
		} catch (Exception e) {
			logger.error("Exception in get details:" + e.getMessage());
			return null;
		}
	}
	
	@Override
	public Registration getDetailsById(String regId) {
		try {
			String hql = "FROM Registration WHERE regId=:regId AND isActive=true";
			return (Registration) entityManager.createQuery(hql).setParameter("regId", regId).getSingleResult();
		} catch (Exception e) {
			logger.error("Exception in get details:" + e.getMessage());
			return null;
		}
	}

	@Override
	public Response deleteById(String regId) {
		Response res = CommonUtils.getResponseObject("Deleted UserDetails");
		try {
			Registration reg = getDetailsById(regId);
			reg.setActive(false);
			entityManager.flush();
			for(Address adr:reg.getAddress()) {
				adr.setActive(false);
				entityManager.flush();
			}
			
			return res; 
		/*	String hql = "DELETE FROM Registration WHERE regId=:regId";
			return (Response) entityManager.createQuery(hql).setParameter("regId", regId).getResultList();*/
		} catch (Exception e) {
			
			logger.error("Exception in Delete User :" + e.getMessage());
			res.setStatus(StatusCode.ERROR.name());
			res.setErrors(e.getMessage());
			return res;
		}
		

	}

	@Override
	public Authentication authenticate(Authentication reg) {
		try {
			String hql = "FROM Authentication WHERE userName=:username AND password=:password";
			return (Authentication) entityManager.createQuery(hql).setParameter("username", reg.getUserName())
					.setParameter("password", reg.getPassword()).getSingleResult();
		}catch (Exception e){
			logger.error("Exception in authenticate :" + e.getMessage());
			Response res =new Response();
			res.setMessage(e.getMessage());
			
		}
		return null;
		
	}

	@Override
	public List<Registration> getUsers() {
		try {
			String hql = "FROM Registration WHERE isActive=true";
			return (List<Registration>)entityManager.createQuery(hql).getResultList();
		}catch(Exception e) {
			logger.error("Exception in getUsers:" + e.getMessage());
			return null;
		}
		
	}

}
