package com.multi.todolist.user.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.multi.todolist.user.model.dto.UserDTO;

public class UserDAO {

	public UserDTO userLogin(SqlSession sqlSession, UserDTO user) {
		
		return sqlSession.selectOne("userMapper.selectUser", user);
	}

	public String selectEncryptedPwd(SqlSession sqlSession, UserDTO userDTO) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("userMapper.selectEncryptedPwd", userDTO);
	}
	
}
