package org.ohou.service;

import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.ohou.model.User;
import org.ohou.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

import static org.junit.Assert.*;

public class CustomUserDetailServiceImplTest {

    @InjectMocks
    private CustomUserDetailServiceImpl customUserDetailService;

    @Mock
    private UserRepository userRepository;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void loadUserByUsername_UserFound_ReturnsUserDetails(){
        String username = "user1";
        User user = new User();
        user.setUsername(username);
        user.setPassword("password1");
        when(userRepository.findByUsername(username)).thenReturn(user);

        UserDetails userDetails = customUserDetailService.loadUserByUsername(username);

        assertNotNull(userDetails);
        assertEquals(username, userDetails.getUsername());
        assertEquals("password1", userDetails.getPassword());
    }



}