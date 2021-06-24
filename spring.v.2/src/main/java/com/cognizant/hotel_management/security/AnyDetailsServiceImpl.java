package com.cognizant.hotel_management.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;

import com.cognizant.hotel_management.repository.UsersRepository;
 
public class AnyDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private UsersRepository userRepository;
     
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Users user = userRepository.getUserByUsername(username);
         
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
         
        return new AnyDetailsImpl(user);
    }
 
}
