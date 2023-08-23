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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"file:src/main/resources/META-INF/persistence.xml","file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
//@ContextConfiguration(locations = {"classpath:/META-INF/persistence.xml","classpath:/WEB-INF/spring/**/*.xml"})
//@ContextConfiguration(locations = "classpath:/WEB-INF/spring/context-security.xml")
public class CustomUserDetailServiceImplTest {

    @Test
    public void test1(){}

//    @InjectMocks
//    private CustomUserDetailServiceImpl customUserDetailService;
//
//    @Mock
//    private UserRepository userRepository;
//
//    @Before
//    public void setup(){
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void loadUserByUsername_UserFound_ReturnsUserDetails(){
//        String username = "user1";
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword("password1");
//        when(userRepository.findByUsername(username)).thenReturn(user);
//
//        UserDetails userDetails = customUserDetailService.loadUserByUsername(username);
//
//        assertNotNull(userDetails);
//        assertEquals(username, userDetails.getUsername());
//        assertEquals("password1", userDetails.getPassword());
//    }



}