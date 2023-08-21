package org.ohou.service;

import org.ohou.model.Authority;
import org.ohou.model.User;
import org.ohou.repository.AuthorityRepository;
import org.ohou.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CustomUserDetailServiceImpl implements CustomUserDetailService {

    private final UserRepository userRepository;

    private final AuthorityRepository authorityRepository;

    @Autowired
    public CustomUserDetailServiceImpl(UserRepository userRepository, AuthorityRepository authorityRepository){
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("User not found");
        }
        Collection<GrantedAuthority> authorities = getAuthorities(username);

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                authorities
        );
    }

    public Collection<GrantedAuthority> getAuthorities(String username){
        List<Authority> authList = authorityRepository.findByUsername(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        for(Authority authority : authList){
            authorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
        }
        return authorities;
    }
}
