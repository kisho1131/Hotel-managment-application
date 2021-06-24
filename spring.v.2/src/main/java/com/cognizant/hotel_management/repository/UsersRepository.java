package com.cognizant.hotel_management.repository;
/*
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.hotel_management.security.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	
	//Optional<User> findByUserName(String userName);
	@Query("SELECT u FROM User u WHERE u.username = :username")
    public Optional<User> findByUserName(@Param("username") String username);
}
*/
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cognizant.hotel_management.security.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{
	
    @Query("SELECT u FROM Users u join u.roles r WHERE u.username = :username and r.roleName='USER'")
    public List<Users> findUser(@Param("username") String username);

    @Query("SELECT u FROM Users u join u.roles r WHERE u.username = :username and r.roleName='ADMIN'")
    public List<Users> findAdmin(@Param("username") String username);
    
    @Query("SELECT u FROM Users u join u.roles r WHERE u.username = :username")
    public List<Users> findAny(@Param("username") String username);
    
    @Query("SELECT u FROM Users u join u.roles r WHERE u.username = :username")
    public Users getUserByUsername(@Param("username") String username);
}