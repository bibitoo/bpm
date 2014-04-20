package cc.landking.web.bpm.identity;

import org.activiti.engine.impl.interceptor.Session;
import org.activiti.engine.impl.interceptor.SessionFactory;
import org.activiti.engine.impl.persistence.entity.GroupEntityManager;
import org.activiti.engine.impl.persistence.entity.GroupIdentityManager;
import org.springframework.beans.factory.annotation.Autowired;

public class LandkingGroupsSessionFactory implements SessionFactory {
	private LandkingGroupIdentityManager landkingGroupIdentityManager;  
	@Autowired  
    public void setLandkingGroupIdentityManager(LandkingGroupIdentityManager landkingGroupIdentityManager) {  
        this.landkingGroupIdentityManager = landkingGroupIdentityManager;  
    }  
	@Override
	public Class<?> getSessionType() {
		return GroupIdentityManager.class;
	}

	@Override
	public Session openSession() {
		 return landkingGroupIdentityManager; 
	}

}
