package com.example.backend.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.backend.model.UserModel;

public interface UserRepo extends MongoRepository<UserModel, String> {
	
	List<UserModel> findByUsernameAndPassword(String username,String password);
	
	Optional<UserModel> findByUsername(String username); 
	
	

}
