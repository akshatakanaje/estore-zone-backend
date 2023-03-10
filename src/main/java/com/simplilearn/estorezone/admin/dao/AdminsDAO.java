package com.simplilearn.estorezone.admin.dao;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.simplilearn.estorezone.admin.model.Admins;
import com.simplilearn.estorezone.admin.model.Response;
import com.simplilearn.estorezone.utility.DB;

public class AdminsDAO implements DAO<Admins>{   //its a interface so it should implements

	DB db = new DB();
	
	// login as admin user
		public Admins login(String email, String password) {
			Admins admin = new Admins();
			db.init();
			try {
				String sql = "select * from admins where email='"+email+"' and password='"+password+"'";
				ResultSet res =  db.executeQuery(sql);
				if(res.next()) {
					admin.setAdminId(res.getInt("adminId"));
					admin.setFullName(res.getString("fullName"));
					admin.setEmail(res.getString("email"));
					admin.setPassword(res.getString("password"));
					admin.setLoginType(res.getInt("loginType"));
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					admin.setAddedOn(format.parse(res.getString("addedOn")));
				}

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Something went wrong :: " + e.getMessage());
			} finally {
				db.destroy();
			}
			return admin;
		}
		
	
	public List<Admins> getAll() {
		List<Admins> adminList = new ArrayList<Admins>(); //here we need list of record so we are using List<Admins>
		db.init();
		try {
			String sql = "select * from admins";
			ResultSet res = db.executeQuery(sql);
			
			while(res.next()) {//here we are using iterator and this iterator i am going to apply on ResultSet object
				Admins admin = new Admins();
				admin.setAdminId(res.getInt("adminId"));
				admin.setFullName(res.getString("fullName"));
				admin.setEmail(res.getString("email"));
				admin.setPassword(res.getString("password"));
				admin.setLoginType(res.getInt("loginType"));
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				admin.setAddedOn(format.parse(res.getString("addedon")));
				
				adminList.add(admin);
				
			}
		} catch(Exception e) {
			e.printStackTrace(); 
			System.out.println("-- Something Went Wrong: --"+ e.getMessage());
		} finally {
			db.destroy();
		}
		return adminList;
	}

	
	public Admins getOne(long id) {
		Admins admin = new Admins(); //here we need a particular admin id record
		db.init();
		try {
			String sql = "select * from admins where adminId = " + id;
			ResultSet res = db.executeQuery(sql);
			
			if(res.next()) {
				admin.setAdminId(res.getInt("adminId"));
				admin.setFullName(res.getString("fullName"));
				admin.setEmail(res.getString("email"));
				admin.setPassword(res.getString("password"));
				admin.setLoginType(res.getInt("loginType"));
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				admin.setAddedOn(format.parse(res.getString("addedon")));
			}		
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("-- Something Went Wrong: --"+ e.getMessage());
		} finally {
			db.destroy();
		}
		
		return admin;
	}

	public int save(Admins obj) {
		db.init();
		try {
			String sql = "insert into admins (email, password, fullName, loginType) values ('"+obj.getEmail()+"', '"+obj.getPassword()+"', '"+obj.getFullName()
			+"', '"+obj.getLoginType()+"')";
			int rowAffected = db.executeUpdate(sql); //int because we need id to update the admin record
			String message = (rowAffected > 0) ? "Adimn record saved auccessfully" : "Unable to save Admin data";
			System.out.println(message);
			return rowAffected;
			
		} catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("-- Something Went Wrong:: "+ e.getMessage());
		} finally {
			db.destroy();
		}
	}

	public int update(Admins obj) {
		db.init();
		try {
			String sql = "update admins set email = '"+obj.getEmail()+"', password = '"+obj.getPassword()+"', fullName = '"+obj.getFullName()
			+"', loginType = "+obj.getLoginType()+" where adminId = "+obj.getAdminId();
			int rowAffected = db.executeUpdate(sql);
			String message = (rowAffected > 0) ? "Admin recoed updated successfully" : "Unable to update Adim data";
			System.out.println(message);
			return rowAffected;
			
		} catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("-- Something Went Wrong:: "+ e.getMessage());
		} finally {
			db.destroy();
		}		
	}

	public int delete(long id) {
		db.init();
		try {
			String sql = "delete from admins where adminId = " + id;
			int rowAffected = db.executeUpdate(sql);
			String message = (rowAffected > 0 ? "Admin record deleted successfully" : "Unable to delete Admin record");
			System.out.println(message);
			return rowAffected;
			
		} catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("-- Something Went Wrong:: "+ e.getMessage());
		} finally {
			db.destroy();
		}		
	}
}
