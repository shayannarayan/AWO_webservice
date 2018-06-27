package com.awo.app.dao.registration;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.awo.app.constant.StatusCode;
import com.awo.app.dao.authentication.AuthDao;
import com.awo.app.domain.authentication.Authentication;
import com.awo.app.domain.registration.Registration;
import com.awo.app.model.registration.RegistrationModel;
import com.awo.app.response.Response;
import com.awo.app.utils.CommonUtils;

@Transactional
@Repository
public class RegDaoImp implements RegDao {

	private static final Logger logger = LoggerFactory.getLogger(RegDaoImp.class);

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private AuthDao authDao;

	@Override
	public Response saveReg(Registration reg) {
		Response res = CommonUtils.getResponseObject("Saved User Registration Dtails");
		try {
			 entityManager.persist(reg);
			 
		} catch (Exception e) {
			logger.error("Exception in saving RegistrationDetails :" + e.getMessage()	);
			res.setStatus(StatusCode.ERROR.name());
			res.setErrors(e.getMessage());
			
		}
		return res;
	}

	@Override
	public List<String> getDetailsByAreaAndPincode(RegistrationModel regAdr) {
		try {
			List<String> id = new ArrayList<String>();
			if((regAdr.getState()==null) && (regAdr.getCity()==null) && (regAdr.getPincode()==null) && (regAdr.getBloodGroup()!=null)) {
				String hql = "SELECT regId FROM Registration WHERE bloodGroup=:bloodGroup AND isActive=true";
				id = entityManager.createQuery(hql).setParameter("bloodGroup", regAdr.getBloodGroup()).getResultList();
			}
			else if((regAdr.getCity()==null) && (regAdr.getPincode()==null) && (regAdr.getBloodGroup()!=null) && (regAdr.getState()!=null)) {
				String hql = "SELECT regId FROM Registration WHERE bloodGroup=:bloodGroup AND availability=true AND isActive=true AND regId in(SELECT regId FROM Address WHERE state=:state AND isActive=true)";
				id = entityManager.createQuery(hql).setParameter("bloodGroup", regAdr.getBloodGroup()).setParameter("state", regAdr.getState()).getResultList();
			}
			else if((regAdr.getPincode()==null) && (regAdr.getBloodGroup()!=null) && (regAdr.getState()!=null) && (regAdr.getCity()!=null)) {
				String hql = "SELECT regId FROM Registration WHERE bloodGroup=:bloodGroup AND availability=true AND isActive=true AND regId in(SELECT regId FROM Address WHERE state=:state AND city=:city AND isActive=true GROUP BY regId)";
				id = entityManager.createQuery(hql).setParameter("bloodGroup", regAdr.getBloodGroup()).setParameter("state", regAdr.getState()).setParameter("city", regAdr.getCity()).getResultList();
			}else {
			String hql ="SELECT regId FROM Registration WHERE bloodGroup=:bloodGroup AND availability=true AND isActive=true AND regId in(SELECT regId FROM Address WHERE state=:state AND pincode=:pincode AND city=:city AND isActive=true GROUP BY regId)";
			id =  entityManager.createQuery(hql).setParameter("bloodGroup", regAdr.getBloodGroup()).setParameter("state", regAdr.getState()).setParameter("pincode", regAdr.getPincode()).setParameter("city", regAdr.getCity()).getResultList();
			}
			
		/*	String hql = "SELECT DISTINCT regId FROM Address WHERE (state=:state AND city=:city AND pincode=:code)";
			List<String> id =  entityManager.createQuery(hql).setParameter("state", state).setParameter("city", city).setParameter("code", pincode).getResultList();
			String hql1 = "SELECT DISTINCT regId FROM Registration WHERE bloodGroup=:blood" ;
			List<String> id1 =  entityManager.createQuery(hql1).setParameter("blood", bloodGroup).getResultList();
			id.addAll(id1);
			id = unique(id);*/
			System.out.println(id);
			if(id.isEmpty()) {
			return null;
			}
			return id;
		} catch (Exception e) {
			logger.error("Exception in get details:" + e.getMessage());
			return null;
		}
	}
private List<String> unique(List<String> id) {
			Set<String> hs = new HashSet<>();
			hs.addAll(id);
			List<String> id1 = new ArrayList<String>();
			id1.addAll(hs);
			return id1;
		
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
			/*for(Address adr:reg.getAddress()) {
				adr.setActive(false);
				entityManager.flush();
			}*/
			
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
	public String authenticate(RegistrationModel model) {
		try {
			
//			SELECT (SELECT regId FROM Address WHERE (emailId=? OR mobile=?)) FROM Address WHERE regId in (SELECT regId FROM Authentication WHERE password=?)
			
			String hql ="SELECT regId FROM Authentication WHERE password=? AND isActive=true AND regId in (SELECT regId FROM Address WHERE (emailId=? OR mobile=?) AND isActive=true)";
			String auth= (String) entityManager.createQuery(hql).setParameter(1, model.getEmailId()).setParameter(2, model.getMobile())
					.setParameter(0, model.getPassword()).getSingleResult();
				System.out.println(auth);
				if(auth.isEmpty()) {
					return null;
				}
					return auth;
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

	@Override
	public String isDonorExist(RegistrationModel model) {
		try {
		String hql = "SELECT regId FROM Address WHERE emailId=:id AND isActive=true";
		return (String) entityManager.createQuery(hql).setParameter("id", model.getEmailId()).getSingleResult();
		}catch(Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	@Override
	public String resetPassword(String regId, String encriptString) {
		try {
		Authentication auth = authDao.getAuth(regId);
		auth.setPassword(encriptString);
		System.out.println(regId);
		entityManager.flush();
		return StatusCode.SUCCESS.name();
		}catch(Exception e) {
			logger.error("Exception ResetPassword:"+e.getMessage());
			return StatusCode.ERROR.name();
		}
	}
		

}
