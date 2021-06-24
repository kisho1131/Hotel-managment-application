package com.cognizant.hotel_management.security;

/*
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.hotel_management.repository.UsersRepository;

@Service
public class AnyDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		List<Users> usersList = usersRepository.findAny(userName);

		if (usersList != null && usersList.size() == 1) {
			Users users = usersList.get(0);

			List<String> roleList = new ArrayList<String>();
			for (Role role : users.getRoles()) {
				roleList.add(role.getRoleName());
			}

            return User.builder()
                	.username(users.getUsername())
                	//change here to store encoded password in db
                	.password( bCryptPasswordEncoder.encode(users.getPassword()) )
                	.disabled(users.isDisabled())
                	.accountExpired(users.isAccountExpired())
                	.accountLocked(users.isAccountLocked())
                	.credentialsExpired(users.isCredentialsExpired())
                	.roles(roleList.toArray(new String[0]))
                	.build();
		} else {
			throw new UsernameNotFoundException("User Name is not Found");
		}
	}
}
*/

import java.util.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
 
public class AnyDetailsImpl implements UserDetails {
	
    private Users user;
     
    public AnyDetailsImpl(Users user) {
        this.user = user;
    }
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Role> roles = user.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
         
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
         
        return authorities;
    }
 
    @Override
    public String getPassword() {
        return user.getPassword();
    }
 
    @Override
    public String getUsername() {
        return user.getUsername();
    }
 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return !user.isDisabled();
    }
 
}