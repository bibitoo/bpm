package cc.landking.web.bpm.identity;

import org.activiti.engine.impl.interceptor.Session;
import org.activiti.engine.impl.interceptor.SessionFactory;
import org.activiti.engine.impl.persistence.entity.UserEntityManager;
import org.activiti.engine.impl.persistence.entity.UserIdentityManager;
import org.springframework.beans.factory.annotation.Autowired;

public class LandkingUsersSessionFactory implements SessionFactory {
	
	private LandkingUserIdentityManager landkingUserIdentityManager;

	@Autowired
	public void setLandkingUserIdentityManager(LandkingUserIdentityManager landkingUserIdentityManager) {
		this.landkingUserIdentityManager = landkingUserIdentityManager;
	}

	@Override
	public Class<?> getSessionType() {
		return UserIdentityManager.class;
	}

	@Override
	public Session openSession() {
		 return landkingUserIdentityManager; 
	}

}
