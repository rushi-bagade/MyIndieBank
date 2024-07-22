package com.rbi.MyIndieBank.User.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rbi.MyIndieBank.User.dto.LoginDTO;
import com.rbi.MyIndieBank.User.dto.UserDTO;
import com.rbi.MyIndieBank.User.exception.MyIndieBankGlobalExceptionHandler;
import com.rbi.MyIndieBank.User.service.UserService;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/myindiebank")
public class UserApi {

	@Autowired
	UserService userService;

	@PostMapping("/users")
	public ResponseEntity<String> createUser(@RequestBody @Valid UserDTO userDTO) throws MyIndieBankGlobalExceptionHandler {

		String str = userService.createUser(userDTO);

		return new ResponseEntity<>(str, HttpStatus.CREATED);

	}

	@PostMapping("/users/login")
	public ResponseEntity<Boolean> loginUser(@RequestBody @Valid LoginDTO loginDTO) throws MyIndieBankGlobalExceptionHandler {

		Boolean val = userService.loginUser(loginDTO);
		return new ResponseEntity<>(val, HttpStatus.OK);

	}

	@GetMapping("/users/{userId}")
	public ResponseEntity<UserDTO> getUserProfile(@PathVariable int userId) throws MyIndieBankGlobalExceptionHandler {

		UserDTO UDTO = userService.getUserProfile(userId);
		return new ResponseEntity<>(UDTO, HttpStatus.OK);
	}

	
	@GetMapping("/users/all")
	public ResponseEntity<List<UserDTO>> showAllUsers() throws MyIndieBankGlobalExceptionHandler {

		List<UserDTO> listDTO = userService.showAllUsers();

		return new ResponseEntity<List<UserDTO>>(listDTO, HttpStatus.OK);

	}
}
