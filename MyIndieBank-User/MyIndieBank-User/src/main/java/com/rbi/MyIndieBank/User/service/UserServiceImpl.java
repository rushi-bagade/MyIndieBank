package com.rbi.MyIndieBank.User.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rbi.MyIndieBank.User.dto.LoginDTO;
import com.rbi.MyIndieBank.User.dto.UserDTO;
import com.rbi.MyIndieBank.User.entity.User;
import com.rbi.MyIndieBank.User.exception.MyIndieBankGlobalExceptionHandler;
import com.rbi.MyIndieBank.User.repository.UserRepository;


import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	ModelMapper modelMapper;

	    // Convert Dto to entity
		public User convertToEntity(UserDTO userDTO) {
			return modelMapper.map(userDTO, User.class);
		}

		// Convert entity to dto
		public UserDTO convertToDto(User user) {
			return modelMapper.map(user, UserDTO.class);
		}
	
	@Override
	public String createUser(UserDTO userDTO) throws MyIndieBankGlobalExceptionHandler {

		User u = userRepository.findByMobileNumber(userDTO.getMobileNumber());
		if(u !=null) {
			throw new MyIndieBankGlobalExceptionHandler("USER_ALREADY_EXISTS");
		}
				User entity = convertToEntity(userDTO);
			 entity = userRepository.save(entity);
		
		return "User created Successfully..!"+entity.getUserId();
	}

	@Override
	public Boolean loginUser(LoginDTO loginDTO) throws MyIndieBankGlobalExceptionHandler {

		User user = userRepository.findByMobileNumber(loginDTO.getMobileNumber());
		if(user!= null) {
		if(loginDTO.getPassword().equals(user.getPassword())) { 
			return true;
		}
		else {
			throw new MyIndieBankGlobalExceptionHandler("INVALID_PASSWORD");
		}
		}else {
			throw new MyIndieBankGlobalExceptionHandler("USER_NOT_REGISTERED");
		}		
	}

	
	@Override
	public UserDTO getUserProfile(int userId) throws MyIndieBankGlobalExceptionHandler {//same user id is not inserting here
		
		User user = userRepository.findByUserId(userId);
		if(user!=null) {
			throw new MyIndieBankGlobalExceptionHandler("USER_NOT_FOUND");
		}
			UserDTO dto = convertToDto(user);
		return dto;
	}

	@Override
	public List<UserDTO> showAllUsers() throws MyIndieBankGlobalExceptionHandler {
		
		List<User> all = userRepository.findAll();
		if(all == null) {
			throw new MyIndieBankGlobalExceptionHandler("NO_USERS_FOUND");
		}
		
		List<UserDTO> userList = new ArrayList<>();
		
		for(User x:all) {
			UserDTO dto = convertToDto(x);
			userList.add(dto);
		}
				
		return userList;
	}

}
