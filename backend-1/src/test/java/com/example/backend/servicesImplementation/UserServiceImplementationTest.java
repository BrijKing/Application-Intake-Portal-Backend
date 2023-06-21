package com.example.backend.servicesImplementation;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.backend.model.User;
import com.example.backend.repo.UserRepo;

@SpringBootTest
public class UserServiceImplementationTest {

	@Mock
	UserRepo userRepo;

	@InjectMocks
	UserServiceImplementation userServiceImplementation;

	@Mock
	User user;

	@BeforeEach
	public void beforeEach() {
		user.setId("1");
		user.setEmail("test@email.com");
		user.setIs_approved(1);
		user.setIsRegisterWithGoogle(1);
		user.setIsVerified(1);
		user.setMono("1234567890");
		user.setPassword("testPassword");
		user.setRole("ROLE_ADMIN");
	}

	@Test
	public void test_register() {
		
        when(userRepo.save(user)).thenReturn(user);

       
        User registeredUser = userServiceImplementation.register(user);

        assertEquals(user.getEmail(), registeredUser.getEmail());
        assertEquals(user.getPassword(), registeredUser.getPassword());
		
		
	}

	@Test
	public void test_login() {

		List<User> userList = new ArrayList<>();
		userList.add(user);
		when(userRepo.findByEmailAndPassword(user.getEmail(), user.getPassword())).thenReturn(userList);

		String result = userServiceImplementation.login(user);

		assertEquals("User Found", result);
	}


	@Test
	public void test_deleteByEmail() {
		String email = "test@example.com";

        
        String result = userServiceImplementation.deleteByEmail(email);

        verify(userRepo).deleteByEmail(email);

        
        assertEquals("User Deleted Successfully", result);
	}
	
	@Test
	public void test_getAllUser() {
		List<User> userList = new ArrayList<>();
		userList.add(user);

        // Configure the behavior of the userRepo mock
        when(userRepo.findAllVerifiedUsers()).thenReturn(userList);

        // Call the getAllUsers method
        List<User> result = userServiceImplementation.getAllUsers();

        // Assert the expected result
        assertEquals(userList.size(), result.size());
        assertEquals(userList.get(0).getId(), result.get(0).getId());
	}
	
	@Test
	public void test_updateByEmail() {
		 String email = "test@example.com";

	        
	     String result = userServiceImplementation.updateByEmail(email);

	       
	     verify(userRepo).updateIsApproved(email, 1);

	        
	     assertEquals("updated", result);
	}

}
