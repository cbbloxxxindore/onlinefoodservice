package com.gurukripa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gurukripa.dao.UseRepo;
import com.gurukripa.entites.User;

@Service
public class UserSevice {
@Autowired
	private UseRepo userRepo;
	public User AddUser(User u)
	{
		User user =null;
		try
		{
		user=userRepo.save(u);
	}
	catch( UsernameNotFoundException e)
	{
		e.printStackTrace();
		
	}
		return user;
	}
	public User updateUser(User u)
	{
		User user =null;
		try
		{
		user=userRepo.save(u);
	}
	catch( UsernameNotFoundException e)
	{
		e.printStackTrace();
		
	}
		return user;
	}
	
	public void deleteUser(int u)
	{
		try
		{
		userRepo.deleteById(u);
	}
	catch( UsernameNotFoundException e)
	{
		e.printStackTrace();
		
	}
		
	}
	public Optional<User> getUser(int u)
	{
		Optional<User> user =null;
		try
		{
		user=userRepo.findById(u);
	}
	catch( UsernameNotFoundException e)
	{
		e.printStackTrace();
		
	}
		return user;
	}
	public List<User> getAllUser()
	{
		List<User> list =null;
		try
		{
		list=userRepo.findAll();
	}
	catch( Exception e)
	{
		e.printStackTrace();
		
	}
		return list;
	}

}
