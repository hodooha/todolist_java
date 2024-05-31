package com.multi.todolist.task.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.multi.todolist.task.model.dto.TaskDTO;
import com.multi.todolist.task.service.TaskService;
import com.multi.todolist.task.service.TaskServiceImpl;
import com.multi.todolist.user.model.dto.UserDTO;

/**
 * Servlet implementation class TaskInsertServlet
 */
@WebServlet("/task/insert")
public class TaskInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TaskService taskService = new TaskServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "";

		path = "/WEB-INF/views/task/insertform.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String task = request.getParameter("task");
		TaskDTO taskDTO = new TaskDTO();
		taskDTO.setContent(task);
		UserDTO loginUser = (UserDTO) session.getAttribute("loginUser");
		taskDTO.setUserId(loginUser.getUserId());
		
		int result = taskService.insertTask(taskDTO);
	}

}
