package com.gurukripa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gurukripa.entites.User;
import com.gurukripa.service.UserSevice;

@RestController
public class UserContoller {
	@Autowired
	BCryptPasswordEncoder bc;
@Autowired
 private UserSevice userSevice;
@PostMapping("/user1")
public ResponseEntity<User> AddUser (@RequestBody User u)
{
	User user =null;
	try
	{
		u.setPassword(bc.encode(u.getPassword()));
	user=userSevice.AddUser(u);
}
catch( UsernameNotFoundException e)
{
	e.printStackTrace();
	 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
}
	return ResponseEntity.ok(user);
}
@PutMapping("/user")
public ResponseEntity<User> updateUser(@RequestBody User u)
{
	User user =null;
	try
	{
		u.setPassword(bc.encode(u.getPassword()));

	user=userSevice.updateUser(u);
}
catch( UsernameNotFoundException e)
{
	e.printStackTrace();
	ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

}
	return ResponseEntity.ok(user);
}
@DeleteMapping("/user/{id}")
public ResponseEntity<Void> deleteUser(@PathVariable("id ")int u)
{
	try
	{
	userSevice.deleteUser(u);

	
	}
catch(Exception e)
{
	e.printStackTrace();
	ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
}
	return ResponseEntity.noContent().build();
}
@GetMapping("/user/{id}")
public ResponseEntity<Optional<User>> getUser(@PathVariable("id")int u)
{
	Optional<User> user =null;
	try
	{
	user=userSevice.getUser(u);

	}
catch( UsernameNotFoundException e)
{
	e.printStackTrace();
	return   ResponseEntity.status(HttpStatus.NOT_FOUND).build();
}
	return 	ResponseEntity.of(Optional.of(user));

}
@GetMapping("/user")

public ResponseEntity<List<User>>getAllUser()
{
	List<User> list =null;
	try
	{
	list=userSevice.getAllUser();
}
catch( Exception e)
{
	e.printStackTrace();
	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

}
	 	return 	ResponseEntity.of(Optional.of(list));

}
}
