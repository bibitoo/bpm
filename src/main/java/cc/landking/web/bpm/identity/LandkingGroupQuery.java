package cc.landking.web.bpm.identity;

import java.util.List;

import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.GroupQuery;

public class LandkingGroupQuery implements GroupQuery {

	@Override
	public GroupQuery asc() {
		return this;
	}

	@Override
	public GroupQuery desc() {
		return this;
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public Group singleResult() {
		return null;
	}

	@Override
	public List<Group> list() {
		return null;
	}

	@Override
	public List<Group> listPage(int firstResult, int maxResults) {
		return null;
	}

	@Override
	public GroupQuery groupId(String groupId) {
		return this;
	}

	@Override
	public GroupQuery groupName(String groupName) {
		return null;
	}

	@Override
	public GroupQuery groupNameLike(String groupNameLike) {
		return null;
	}

	@Override
	public GroupQuery groupType(String groupType) {
		return null;
	}

	@Override
	public GroupQuery groupMember(String groupMemberUserId) {
		return null;
	}

	@Override
	public GroupQuery potentialStarter(String procDefId) {
		return null;
	}

	@Override
	public GroupQuery orderByGroupId() {
		return null;
	}

	@Override
	public GroupQuery orderByGroupName() {
		return null;
	}

	@Override
	public GroupQuery orderByGroupType() {
		return null;
	}

}
