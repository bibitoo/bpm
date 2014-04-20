package cc.landking.web.bpm.identity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.GroupQuery;
import org.activiti.engine.impl.GroupQueryImpl;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.interceptor.Session;
import org.activiti.engine.impl.persistence.entity.GroupEntity;
import org.activiti.engine.impl.persistence.entity.GroupEntityManager;
import org.activiti.engine.impl.persistence.entity.GroupIdentityManager;

import cc.landking.web.core.service.LandkingUser;
import cc.landking.web.core.service.OrganizationData;
import cc.landking.web.core.service.OrganizationSpiService;

public class LandkingGroupIdentityManager  extends GroupEntityManager  implements GroupIdentityManager, Session {
	
	private OrganizationSpiService organizationSpiService;
	
	public void setOrganizationSpiService(
			OrganizationSpiService organizationSpiService) {
		this.organizationSpiService = organizationSpiService;
	}

	@Override
	public Group createNewGroup(String groupId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertGroup(Group group) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateGroup(Group updatedGroup) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteGroup(String groupId) {
		// TODO Auto-generated method stub

	}

	@Override
	public GroupQuery createNewGroupQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Group> findGroupByQueryCriteria(GroupQueryImpl query, Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long findGroupCountByQueryCriteria(GroupQueryImpl query) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Group> findGroupsByUser(String userId) {
		LandkingUser user = organizationSpiService.getUser(userId, null);
		List<Group> groups = new ArrayList<Group>();
		for(String org:user.getOrganizations()){
			OrganizationData odata = organizationSpiService.getById(org);
			GroupEntity group = new GroupEntity(odata.getName());
			groups.add(group);
		}
		return groups;
	}

	@Override
	public List<Group> findGroupsByNativeQuery(
			Map<String, Object> parameterMap, int firstResult, int maxResults) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long findGroupCountByNativeQuery(Map<String, Object> parameterMap) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isNewGroup(Group group) {
		// TODO Auto-generated method stub
		return false;
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
