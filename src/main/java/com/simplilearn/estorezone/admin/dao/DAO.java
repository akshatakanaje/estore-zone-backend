package com.simplilearn.estorezone.admin.dao;

import java.util.List;

public interface DAO<T> {        //these are the 5 common methods 
	                            //here T represents the Type
	//get all records          // here we wanted to have DAO of generic Type 
	List<T> getAll();        //generic Type means you should able to store or insert any type of object
	
	//get one record
	T getOne(long id);        //id -- because we need  one particular id to get admin record 
	 
	//create a record
	int save(T obj);   //here we are passing a data admin then the Type should be admin Type of object
	
	//update a record
	int update (T obj);
	
	//delete a record
	int delete(long id);     //id -- because we need one particular id to delete that id record

}
