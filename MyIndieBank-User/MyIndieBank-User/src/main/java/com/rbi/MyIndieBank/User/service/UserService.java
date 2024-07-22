package com.rbi.MyIndieBank.User.service;

import java.util.List;

import com.rbi.MyIndieBank.User.dto.LoginDTO;
import com.rbi.MyIndieBank.User.dto.UserDTO;
import com.rbi.MyIndieBank.User.exception.MyIndieBankGlobalExceptionHandler;

public interface UserService {

	String createUser(UserDTO userDTO)throws MyIndieBankGlobalExceptionHandler;

	Boolean loginUser(LoginDTO loginDTO)throws MyIndieBankGlobalExceptionHandler;

	UserDTO getUserProfile(int userId)throws MyIndieBankGlobalExceptionHandler;

	List<UserDTO> showAllUsers()throws MyIndieBankGlobalExceptionHandler;

}
