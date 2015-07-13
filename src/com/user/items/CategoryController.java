package com.user.items;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import driver.Driver;

public class CategoryController {
	public static Category getCategory(int  id)  {
		//add new item to table
		try{
			Connection connection = (new Driver()).getConnection();
			Statement statement = connection.createStatement();
			
			ResultSet rs = statement.executeQuery("SELECT * from category WHERE id="+id);
			Category category = null;
			while(rs.next()){
				category = new Category(rs.getInt("id"), rs.getString("name"));
			}
			connection.close();
			statement.close();
			return category;
		}
		catch(ClassNotFoundException e){
			System.out.println("ClassNotFoundException");
		}
		catch(SQLException e){
			System.out.println("SQLException");
		}
		return null;
		
	}
	
	public static Category getCategoryByName(String name) {
		//add new item to table
		try{
			Connection connection = (new Driver()).getConnection();
			Statement statement = connection.createStatement();
			
			ResultSet rs = statement.executeQuery("SELECT * from category WHERE name='"+name+"'");
			Category category = null;
			while(rs.next()){
				category = new Category(rs.getInt("id"), rs.getString("name"));
			}
			connection.close();
			statement.close();
			return category;
		}
		catch(ClassNotFoundException e){
			System.out.println("ClassNotFoundException");
		}
		catch(SQLException e){
			System.out.println("SQLException");
		}
		return null;
		
	}
	
	public static ArrayList<Category> displayList(){
		try{
			ArrayList<Category> categories = new ArrayList<Category>();
			Connection connection = (new Driver()).getConnection();
			Statement statement = connection.createStatement();
			Category category;
			ResultSet rs = statement.executeQuery("SELECT * from category");
			
			while(rs.next()){			
				Category item= new Category(
						rs.getInt("id"),
						rs.getString("name"));
						categories.add(item);
			}
			return categories;
		}
		catch(ClassNotFoundException e){
			System.out.println("ClassNotFoundException");
		}
		catch(SQLException e){
			System.out.println("SQLException");
		}
		return null;
		
	}
}
