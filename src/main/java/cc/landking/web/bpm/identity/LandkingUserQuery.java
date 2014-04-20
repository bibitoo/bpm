package cc.landking.web.bpm.identity;

import java.util.List;

import org.activiti.engine.identity.User;
import org.activiti.engine.identity.UserQuery;

public class LandkingUserQuery implements UserQuery {


	protected String id;
	protected String firstName;
	protected String firstNameLike;
	protected String lastName;
	protected String lastNameLike;
	protected String fullNameLike;
	protected String email;
	protected String emailLike;
	protected String groupId;
	protected String procDefId;

	@Override
	public UserQuery asc() {
		return this;
	}

	@Override
	public UserQuery desc() {
		return this;
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public User singleResult() {
		return null;
	}

	@Override
	public List<User> list() {
		return null;
	}

	@Override
	public List<User> listPage(int firstResult, int maxResults) {
		return null;
	}

	@Override
	public UserQuery userId(String id) {
		this.id = id;
		return this;
	}

	@Override
	public UserQuery userFirstName(String firstName) {
		return this;
	}

	@Override
	public UserQuery userFirstNameLike(String firstNameLike) {
		return this;
	}

	@Override
	public UserQuery userLastName(String lastName) {
		return this;
	}

	@Override
	public UserQuery userLastNameLike(String lastNameLike) {
		return this;
	}

	@Override
	public UserQuery userFullNameLike(String fullNameLike) {
		return this;
	}

	@Override
	public UserQuery userEmail(String email) {
		return this;
	}

	@Override
	public UserQuery userEmailLike(String emailLike) {
		return this;
	}

	@Override
	public UserQuery memberOfGroup(String groupId) {
		return this;
	}

	@Override
	public UserQuery potentialStarter(String procDefId) {
		return this;
	}

	@Override
	public UserQuery orderByUserId() {
		return this;
	}

	@Override
	public UserQuery orderByUserFirstName() {
		return this;
	}

	@Override
	public UserQuery orderByUserLastName() {
		return this;
	}

	@Override
	public UserQuery orderByUserEmail() {
		return this;
	}

	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getFirstNameLike() {
		return firstNameLike;
	}

	public String getLastName() {
		return lastName;
	}

	public String getLastNameLike() {
		return lastNameLike;
	}

	public String getEmail() {
		return email;
	}

	public String getEmailLike() {
		return emailLike;
	}

	public String getGroupId() {
		return groupId;
	}

	public String getFullNameLike() {
		return fullNameLike;
	}
}
