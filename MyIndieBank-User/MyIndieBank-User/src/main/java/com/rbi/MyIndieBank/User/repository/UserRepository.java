package com.rbi.MyIndieBank.User.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rbi.MyIndieBank.User.entity.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>{

	User findByMobileNumber(long mobileNumber);

	User findByUserId(int userId);
	

}
