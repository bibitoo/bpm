package cc.landking.web.bpm;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.explorer.Constants;
import org.activiti.explorer.ExplorerApp;
import org.activiti.explorer.identity.LoggedInUser;
import org.activiti.explorer.identity.LoggedInUserImpl;
import org.activiti.explorer.ui.login.DefaultLoginHandler;
import org.activiti.explorer.ui.login.LoginHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class LandkingLoginHandler extends DefaultLoginHandler implements
		LoginHandler {

	  protected transient IdentityService identityService;

	  public LoggedInUserImpl authenticate(String userName, String password) {
	    LoggedInUserImpl loggedInUser = null;
	    if (identityService.checkPassword(userName, password)) {
	      User user = identityService.createUserQuery().userId(userName).singleResult();
	      // Fetch and cache user data
	      loggedInUser = new LoggedInUserImpl(user, password);
	      List<Group> groups = identityService.createGroupQuery().groupMember(user.getId()).list();
	      for (Group group : groups) {

	        if (Constants.SECURITY_ROLE.equals(group.getType())) {
	          loggedInUser.addSecurityRoleGroup(group);
	          if (Constants.SECURITY_ROLE_USER.equals(group.getId())) {
	            loggedInUser.setUser(true);
	          }
	          if (Constants.SECURITY_ROLE_ADMIN.equals(group.getId())) {
	            loggedInUser.setAdmin(true);
	          }
	        } else if (ExplorerApp.get().getAdminGroups() != null
	                    && ExplorerApp.get().getAdminGroups().contains(group.getId())) {
	          loggedInUser.addSecurityRoleGroup(group);
	          loggedInUser.setAdmin(true);
	        } else if (ExplorerApp.get().getUserGroups() != null
	                && ExplorerApp.get().getUserGroups().contains(group.getId())) {
	          loggedInUser.addSecurityRoleGroup(group);
	          loggedInUser.setUser(true);
	        } else {
	          loggedInUser.addGroup(group);
	        }
	        
	        
	      }
	    }
	    
	    return loggedInUser;
	  }
	  
	  public void onRequestStart(HttpServletRequest request, HttpServletResponse response) {
	    // Noting to do here
	  }

	  public void onRequestEnd(HttpServletRequest request, HttpServletResponse response) {
	    // Noting to do here
	  }
	  
	  public LoggedInUser authenticate(HttpServletRequest request, HttpServletResponse response) {
		  LoggedInUserImpl loggedInUser = null;
		  Object securityObject = SecurityContextHolder.getContext()
				    .getAuthentication()
				    .getPrincipal();
		  if(securityObject instanceof UserDetails){
			  UserDetails userDetails = (UserDetails) securityObject;

		      User user = identityService.createUserQuery().userId(userDetails.getUsername()).singleResult();
			    if (user != null) {
		      // Fetch and cache user data
		      loggedInUser = new LoggedInUserImpl(user, userDetails.getPassword());
		      List<Group> groups = identityService.createGroupQuery().groupMember(user.getId()).list();
		      for (Group group : groups) {

		        if (Constants.SECURITY_ROLE.equals(group.getType())) {
		          loggedInUser.addSecurityRoleGroup(group);
		          if (Constants.SECURITY_ROLE_USER.equals(group.getId())) {
		            loggedInUser.setUser(true);
		          }
		          if (Constants.SECURITY_ROLE_ADMIN.equals(group.getId())) {
		            loggedInUser.setAdmin(true);
		          }
		        } else if (ExplorerApp.get().getAdminGroups() != null
		                    && ExplorerApp.get().getAdminGroups().contains(group.getId())) {
		          loggedInUser.addSecurityRoleGroup(group);
		          loggedInUser.setAdmin(true);
		        } else if (ExplorerApp.get().getUserGroups() != null
		                && ExplorerApp.get().getUserGroups().contains(group.getId())) {
		          loggedInUser.addSecurityRoleGroup(group);
		          loggedInUser.setUser(true);
		        } else {
		          loggedInUser.addGroup(group);
		        }
		        
		        
		      }
		    }
		  }
		    return loggedInUser;
	  }
	  
	  public void logout(LoggedInUser userToLogout) {
	    // Clear activiti authentication context
	    Authentication.setAuthenticatedUserId(null);
	  }
	  
	  public void setIdentityService(IdentityService identityService) {
	    this.identityService = identityService;
	  }
}
