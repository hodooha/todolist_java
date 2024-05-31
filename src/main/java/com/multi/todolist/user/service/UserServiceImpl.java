package com.multi.todolist.user.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static com.multi.todolist.common.Template.getSqlSession;

import com.multi.todolist.user.model.dao.UserDAO;
import com.multi.todolist.user.model.dto.UserDTO;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO = new UserDAO();

	@Override
	public UserDTO userLogin(UserDTO userDTO) throws Exception{

		SqlSession sqlSession = getSqlSession();
		UserDTO loginDTO = null;
		String encPwd = userDAO.selectEncryptedPwd(sqlSession, userDTO);
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		if(passwordEncoder.matches(userDTO.getPw(), encPwd)) {
			loginDTO = userDAO.userLogin(sqlSession, userDTO);
			
			
		} 
		sqlSession.close();	
		System.out.println("로그인디티오!!"+loginDTO);
		return loginDTO;
	}

	@Override
	public int insertUser(UserDTO userDTO) throws Exception {
		
		SqlSession sqlSession = getSqlSession();
		int result = userDAO.insertUser(sqlSession, userDTO);
		
		if(result >0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();		
		
		return result;
	}

}
