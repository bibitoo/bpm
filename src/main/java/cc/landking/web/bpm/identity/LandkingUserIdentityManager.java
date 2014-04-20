package cc.landking.web.bpm.identity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.Picture;
import org.activiti.engine.identity.User;
import org.activiti.engine.identity.UserQuery;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.UserQueryImpl;
import org.activiti.engine.impl.interceptor.Session;
import org.activiti.engine.impl.persistence.entity.GroupEntity;
import org.activiti.engine.impl.persistence.entity.IdentityInfoEntity;
import org.activiti.engine.impl.persistence.entity.UserEntity;
import org.activiti.engine.impl.persistence.entity.UserEntityManager;
import org.activiti.engine.impl.persistence.entity.UserIdentityManager;
import org.activiti.explorer.Constants;

import cc.landking.web.core.service.LandkingUser;
import cc.landking.web.core.service.OrganizationData;
import cc.landking.web.core.service.OrganizationSpiService;

public class LandkingUserIdentityManager extends UserEntityManager implements UserIdentityManager, Session {
	private OrganizationSpiService organizationSpiService;
	
	public void setOrganizationSpiService(
			OrganizationSpiService organizationSpiService) {
		this.organizationSpiService = organizationSpiService;
	}

	@Override
	public User createNewUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(User updatedUser) {
		// TODO Auto-generated method stub

	}

	@Override
	public User findUserById(String userId) {
		LandkingUser user = organizationSpiService.getUser(userId, null);
		UserEntity userEntity = new UserEntity(user.getLoginName());
		userEntity.setFirstName(user.getName());
		userEntity.setLastName("");
		return userEntity;
	}

	@Override
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> findUserByQueryCriteria(UserQueryImpl query, Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long findUserCountByQueryCriteria(UserQueryImpl query) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Group> findGroupsByUser(String userId) {
		LandkingUser user = organizationSpiService.getUser(userId, null);
		List<Group> groups = new ArrayList<Group>();
		for(String org:user.getOrganizations()){
			OrganizationData odata = organizationSpiService.getById(org);
			GroupEntity group = new GroupEntity(odata.getId());
			group.setName(odata.getName());
			group.setType(Constants.SECURITY_ROLE_USER);
			groups.add(group);
		}
		if(user.isAdmin() || user.getLoginName().equals("admin")){
			GroupEntity group = new GroupEntity(Constants.SECURITY_ROLE_ADMIN);
			group.setName(Constants.SECURITY_ROLE_ADMIN);
			group.setType(Constants.SECURITY_ROLE);
			groups.add(group);			
		}
		return groups;
	}

	@Override
	public UserQuery createNewUserQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IdentityInfoEntity findUserInfoByUserIdAndKey(String userId,
			String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> findUserInfoKeysByUserIdAndType(String userId,
			String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean checkPassword(String userId, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findPotentialStarterUsers(String proceDefId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findUsersByNativeQuery(Map<String, Object> parameterMap,
			int firstResult, int maxResults) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long findUserCountByNativeQuery(Map<String, Object> parameterMap) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isNewUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Picture getUserPicture(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUserPicture(String userId, Picture picture) {
		// TODO Auto-generated method stub

	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

}
