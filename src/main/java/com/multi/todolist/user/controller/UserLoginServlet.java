package com.multi.todolist.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.multi.todolist.user.model.dto.UserDTO;
import com.multi.todolist.user.service.UserService;
import com.multi.todolist.user.service.UserServiceImpl;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLoginServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userId = request.getParameter("userId");
		String pw = request.getParameter("userPwd");

		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(userId);
		userDTO.setPw(pw);
		String path = "";

		UserDTO loginUser;
		try {
			loginUser = userService.userLogin(userDTO);
			if (loginUser != null) {
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", loginUser);
				response.sendRedirect(request.getContextPath());
			} else {
				path = "/WEB-INF/views/common/failed.jsp";
				request.setAttribute("message", "로그인 실패");
				request.getRequestDispatcher(path).forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "로그인 실패");
			request.getRequestDispatcher(path).forward(request, response);
		}

		
	}

}
