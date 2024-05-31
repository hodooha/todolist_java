package com.multi.todolist.user.service;

import com.multi.todolist.user.model.dto.UserDTO;

public interface UserService {

	UserDTO userLogin(UserDTO userDTO) throws Exception;

	int insertUser(UserDTO userDTO) throws Exception;
	
	
}
