package org.ohou.service;

import org.ohou.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;

public class CustomUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         org.ohou.model.User user = userRepository.findByUsername(username);

         if(user == null) {
             throw new UsernameNotFoundException("사용자를 찾을 수 없습니다. : " + username);
         }

         UserDetails userDetails = User.builder()
                 .username(user.getUsername())
                 .password(user.getPassword())
                 .roles("USER")
                 .build();

        return userDetails;
    }
}
