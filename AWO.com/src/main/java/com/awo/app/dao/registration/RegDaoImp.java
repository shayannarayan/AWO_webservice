package com.awo.app.dao.registration;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.awo.app.constant.StatusCode;
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
			logger.error("Exception in saving RegistrationDetails :" + e);
		/*	res.setStatus(StatusCode.ERROR.name());
			res.setErrors(e.getMessage());*/
			
		}
		return res;
	}

	@Override
	public Registration getById(int regId) {
		try {
			String hql = "FROM Registration WHERE regId=:regId";
			return (Registration) entityManager.createQuery(hql).setParameter("regId", regId).getSingleResult();
		} catch (Exception e) {
			logger.error("Exception in get details:" + e.getMessage());
			return null;
		}
	}

	@Override
	public Response deleteById(int regId) {
		Response res = CommonUtils.getResponseObject("Deleted UserDetails");
		try {
			/*Registration reg = getById(regId);
			entityManager.flush();
			return res;*/  
			String hql = "DELETE FROM Registration WHERE regId=:regId";
			return (Response) entityManager.createQuery(hql).setParameter("regId", regId).getResultList();
		} catch (Exception e) {
			
			logger.error("Exception in Delete User :" + e.getMessage());
			res.setStatus(StatusCode.ERROR.name());
			res.setErrors(e.getMessage());
			return res;
		}
		

	}

	@Override
	public Registration authenticate(Registration reg) {
		try {
			String hql = "FROM Registration WHERE (emailId=:email or phoneNumber=:phone) AND enterPassword=:password";
			return (Registration) entityManager.createQuery(hql).setParameter("email", reg.getEmailId()).setParameter("phone", reg.getPhoneNumber())
					.setParameter("password", reg.getEnterPassword()).getSingleResult();
		}catch (Exception e){
			logger.error("Exception in authenticate :" + e.getMessage());
			Response res =new Response();
			res.setMessage(e.getMessage());
			return null;
		}
		
	}

	@Override
	public List<Registration> getUsers() {
		try {
			String hql = "FROM Registration";
			return (List<Registration>)entityManager.createQuery(hql).getResultList();
		}catch(Exception e) {
			logger.error("Exception in getUsers:" + e.getMessage());
			return null;
		}
		
	}

}
