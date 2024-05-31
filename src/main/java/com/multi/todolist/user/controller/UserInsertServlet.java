package com.multi.todolist.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.multi.todolist.user.model.dto.UserDTO;
import com.multi.todolist.user.service.UserService;
import com.multi.todolist.user.service.UserServiceImpl;

/**
 * Servlet implementation class UserInsertServlet
 */
@WebServlet("/user/insert")
public class UserInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserInsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String path = "/WEB-INF/views/user/insertform.jsp";
		;
		request.getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");

		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(id);
		userDTO.setPw(pw);
		userDTO.setName(name);
		userDTO.setPhone(phone);
		
		int result = userService.insertUser(userDTO);
		
		System.out.println(userDTO);
		

	}

}
