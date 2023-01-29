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
import com.simplilearn.estorezone.admin.dao.AdminsDAO;
import com.simplilearn.estorezone.admin.model.Admins;
import com.simplilearn.estorezone.admin.model.Response;


@WebServlet("/admins") //here we are used WebServel as annotation this is automatically map servlet class with the 
                       //path value i.e any request comes with /admin it will map to the AdminController
public class AdminCrudController extends HttpServlet{
	
	AdminsDAO adminDao = new AdminsDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		          //doGet -- fetch data from server (read)
		String id = request.getParameter("id");
		//List<Admins> adminList = adminDao.getAll();
		List<Admins> adminList = new ArrayList<Admins>();
		String  jsonResponse = null;
		try { 
			if(id != null && Integer.parseInt(id) != 0) {
				Admins admin = adminDao.getOne(Long.parseLong(id));
				 jsonResponse = new Gson().toJson(adminList);
			} else {
				adminList = adminDao.getAll();
			    jsonResponse = new Gson().toJson(adminList);
			}
		//we are also prepare a response that response would be HttpResponse so converting adminList to jsonList
		//json means java script notation object and this java script notion is used to have a exchange of information
			
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
		            //doPost -- send the data to the server(write)
		Response responseDto = new Response();
		try {
			//map admin object fields with request parameter
			Admins admin = new Admins();
		    
			admin.setEmail(request.getParameter("email"));
			admin.setPassword(request.getParameter("password"));
			admin.setFullName(request.getParameter("fullName"));
			admin.setLoginType(Integer.parseInt(request.getParameter("loginType")));
			
			adminDao.save(admin);
			responseDto.setStatus("Success");
			responseDto.setMessage("Admin object saved successfully");
			responseDto.setData(admin);
		} catch(Exception e) {
			e.printStackTrace();
			responseDto.setStatus("Failed");
			responseDto.setMessage("Something Went Wrong, Failed to create admin data");
		}
		String jsonResponse = new Gson().toJson(responseDto);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(jsonResponse);
		out.flush();
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	              //doPut -- update data on server(update)
		Response responseDto = new Response();
		try {
			Admins admin = new Admins();
			admin.setAdminId(Integer.parseInt(request.getParameter("adminId")));
			admin.setEmail(request.getParameter("email"));
			admin.setPassword(request.getParameter("password"));
			admin.setFullName(request.getParameter("fullName"));
			admin.setLoginType(Integer.parseInt(request.getParameter("loginType")));
			
			adminDao.update(admin);
			responseDto.setStatus("Success");
			responseDto.setMessage("Admin object updated successfully");
			responseDto.setData(admin);
		} catch(Exception e) {
			e.printStackTrace();
			responseDto.setStatus("Failed");
			responseDto.setMessage("Something Went Wrong, Failed to update admin data");
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
			String id = request.getParameter("adminId");
			int rowAffected = adminDao.delete(Integer.parseInt(id));
			if(rowAffected > 0) {
				responseDto.setStatus("Success");
				responseDto.setMessage("Admin object deleted successfully");
			} else {
				throw new Exception();
			}
		} catch(Exception e) {
			e.printStackTrace();
			responseDto.setStatus("Failed");
			responseDto.setMessage("Something Went Wrong, Failed to delete admin data");
		}
		String jsonResponse = new Gson().toJson(responseDto);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(jsonResponse);
		out.flush();
	}
}
