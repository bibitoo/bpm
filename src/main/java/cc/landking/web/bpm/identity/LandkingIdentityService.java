package cc.landking.web.bpm.identity;

import java.util.List;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.GroupQuery;
import org.activiti.engine.identity.NativeGroupQuery;
import org.activiti.engine.identity.NativeUserQuery;
import org.activiti.engine.identity.Picture;
import org.activiti.engine.identity.User;
import org.activiti.engine.identity.UserQuery;
import org.activiti.engine.impl.UserQueryImpl;

public class LandkingIdentityService  implements IdentityService {

	@Override
	public User newUser(String userId) {
		return null;
	}

	@Override
	public void saveUser(User user) {

	}

	@Override
	public UserQuery createUserQuery() {
		return new LandkingUserQuery();
	}

	@Override
	public NativeUserQuery createNativeUserQuery() {

		return null;
	}

	@Override
	public void deleteUser(String userId) {
	}

	@Override
	public Group newGroup(String groupId) {
		return null;
	}

	@Override
	public GroupQuery createGroupQuery() {
		return new LandkingGroupQuery();
	}

	@Override
	public NativeGroupQuery createNativeGroupQuery() {
		return null;
	}

	@Override
	public void saveGroup(Group group) {

	}

	@Override
	public void deleteGroup(String groupId) {

	}

	@Override
	public void createMembership(String userId, String groupId) {

	}

	@Override
	public void deleteMembership(String userId, String groupId) {

	}

	@Override
	public boolean checkPassword(String userId, String password) {
		return false;
	}

	@Override
	public void setAuthenticatedUserId(String authenticatedUserId) {

	}

	@Override
	public void setUserPicture(String userId, Picture picture) {

	}

	@Override
	public Picture getUserPicture(String userId) {
		return null;
	}

	@Override
	public void setUserInfo(String userId, String key, String value) {

	}

	@Override
	public String getUserInfo(String userId, String key) {
		return null;
	}

	@Override
	public List<String> getUserInfoKeys(String userId) {
		return null;
	}

	@Override
	public void deleteUserInfo(String userId, String key) {

	}

}
