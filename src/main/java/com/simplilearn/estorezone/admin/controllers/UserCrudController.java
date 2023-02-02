package com.simplilearn.estorezone.admin.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.simplilearn.estorezone.admin.dao.UsersDAO;
import com.simplilearn.estorezone.admin.model.Response;
import com.simplilearn.estorezone.admin.model.Users;



@WebServlet("/users")
public class UserCrudController extends HttpServlet{
	
	UsersDAO userDao = new UsersDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String id = request.getParameter("id");
		List<Users> userList = new ArrayList<Users>();
		String  jsonResponse;
		try {
			if(id != null && Integer.parseInt(id) != 0) {
				Users admin = userDao.getOne(Long.parseLong(id));
				 jsonResponse = new Gson().toJson(userList);
			} else {
				userList = userDao.getAll();
			    jsonResponse = new Gson().toJson(userList);
			}
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(jsonResponse);
			out.flush();
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("-- Something Went Wrong: --"+ e.getMessage());		
			}
	  }
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		Response responseDto = new Response();
		try {
	
			Users user = new Users();		    
			user.setEmail(request.getParameter("email"));
			user.setPassword(request.getParameter("password"));
			user.setFullName(request.getParameter("fullName"));
			user.setStreet(request.getParameter("street"));
			user.setCity(request.getParameter("city"));
			user.setState(request.getParameter("state"));
			user.setCountry(request.getParameter("country"));
			user.setPincode(Integer.parseInt(request.getParameter("pincode")));
			user.setImage(request.getParameter("image"));
			user.setContact(Long.parseLong(request.getParameter("contact")));
						
			userDao.save(user);
			responseDto.setStatus("Success");
			responseDto.setMessage("UserId saved successfully");
			responseDto.setData(user);
		} catch(Exception e) {
			e.printStackTrace();
			responseDto.setStatus("Failed");
			responseDto.setMessage("Something Went Wrong, Failed to create user data");
		}
		String jsonResponse = new Gson().toJson(responseDto);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(jsonResponse);
		out.flush();
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       
		Response responseDto = new Response();
		try {
			Users user = new Users();
			user.setUserId(Integer.parseInt(request.getParameter("userId")));
			user.setEmail(request.getParameter("email"));
			user.setPassword(request.getParameter("password"));
			user.setFullName(request.getParameter("fullName"));
			user.setStreet(request.getParameter("street"));
			user.setCity(request.getParameter("city"));
			user.setState(request.getParameter("state"));
			user.setCountry(request.getParameter("country"));
			user.setPincode(Integer.parseInt(request.getParameter("pincode")));
			user.setImage(request.getParameter("image"));
			user.setContact(Long.parseLong(request.getParameter("contact")));
			
			userDao.update(user);
			responseDto.setStatus("Success");
			responseDto.setMessage("UserId updated successfully");
			responseDto.setData(user);
		} catch(Exception e) {
			e.printStackTrace();
			responseDto.setStatus("Failed");
			responseDto.setMessage("Something Went Wrong, Failed to update user data");
		}
		String jsonResponse = new Gson().toJson(responseDto);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(jsonResponse);
		out.flush();
		}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //deDelete -- delete data on server(delete)
		Response responseDto = new Response();
		try {
			String id = request.getParameter("userId");
			int rowAffected = userDao.delete(Integer.parseInt(id));
			if(rowAffected > 0) {
				responseDto.setStatus("Success");
				responseDto.setMessage("UserId deleted successfully");
			} else {
				throw new Exception();
			}
		} catch(Exception e) {
			e.printStackTrace();
			responseDto.setStatus("Failed");
			responseDto.setMessage("Something Went Wrong, Failed to delete user data");
		}
		String jsonResponse = new Gson().toJson(responseDto);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(jsonResponse);
		out.flush();
		}
}
