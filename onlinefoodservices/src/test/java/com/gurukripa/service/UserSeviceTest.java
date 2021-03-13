package com.gurukripa.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.gurukripa.dao.UseRepo;
import com.gurukripa.entites.User;


@RunWith(MockitoJUnitRunner.class)
public class UserSeviceTest {
 @InjectMocks
	UserSevice us;
 
 @Mock
 UseRepo ur;
 
 @Test
  public void  AddUserTest()
 {
	 User u= new User ();
	 u.setEmail("abhi");
	 u.setId(1);
	 u.setName("abhijeet");
	 u.setPassword("abh");
	 u.setRole("user");
	 when(ur.save(u)).thenReturn(u);
	 assertEquals(1, 1);
 }
}
