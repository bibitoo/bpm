package cc.landking.web.bpm;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class ActivitiUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
		GrantedAuthority auth = new SimpleGrantedAuthority("ROLE_LOGIN");
		roles.add(auth);
		return new User(userName,"*",roles);
	}

}
