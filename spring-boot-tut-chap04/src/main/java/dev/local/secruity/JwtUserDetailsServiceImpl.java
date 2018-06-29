package dev.local.secruity;

import dev.local.user.User;
import dev.local.user.UserRepository;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = generUser();

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return JwtUserFactory.create(user);
        }
    }
    
    public User generUser() {
    	User user = new User();
    	user.setId("1");
    	user.setEmail("000");
    	//user.setLastPasswordResetDate(new Date());
    	user.setPassword("sunqi");
    	user.setUsername("sunqi");
    	user.setRoles(Arrays.asList("ROLE_ADMIN"));
    	return user;
    }
}
