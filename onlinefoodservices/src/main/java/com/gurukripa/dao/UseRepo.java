package com.gurukripa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gurukripa.entites.User;

public interface UseRepo extends JpaRepository <User,Integer> {
@Query("select u from User as u where u.email=:email")
	User getUserByEmail( @Param("email") String username);

}
