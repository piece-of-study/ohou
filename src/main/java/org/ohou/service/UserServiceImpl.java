package org.ohou.service;

import org.ohou.dto.UserDto;
import org.ohou.model.Authority;
import org.ohou.model.User;
import org.ohou.repository.AuthorityRepository;
import org.ohou.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, AuthorityRepository authorityRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    @Transactional
    public User registerUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));

        // 권한 설정 (기본 권한 등)
        Authority authority = new Authority();
        authority.setAuthority("ROLE_USER");
        authority.setUsername(user.getUsername());
        authority.setUser(user);

        userRepository.save(user);
        authorityRepository.save(authority);
        return user;
    }

    @Override
    public void autoLogin(User user) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUsername(),
                user.getPassword(), Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));
        SecurityContextHolder.getContext().setAuthentication(token); // AuthenticationManager를 쓰는 방법이 정석적인 방ㅇ법
    }
}
