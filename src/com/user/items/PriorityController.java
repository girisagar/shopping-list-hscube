package com.user.items;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import driver.Driver;

public class PriorityController {
	public static Priority getPriority(int id) {
		//add new item to table
		try{
			Connection connection = (new Driver()).getConnection();
			Statement statement = connection.createStatement();
			
			ResultSet rs = statement.executeQuery("SELECT * from priority WHERE id="+id);
			Priority priority = null;
			while(rs.next()){
				priority = new Priority(rs.getInt("id"), rs.getString("name"), rs.getInt("value"));
			}

			statement.close();
			connection.close();
			return priority;
		}
		catch(ClassNotFoundException e){
			System.out.println("ClassNotFoundException");
		}
		catch(SQLException e){
			System.out.println("SQLException");
		}
		return null;
		
	}
	
	public static Priority getPriorityByName(String name) {
		try{

			//add new item to table		
			Connection connection = (new Driver()).getConnection();
			Statement statement = connection.createStatement();
			
			ResultSet rs = statement.executeQuery("SELECT * from priority WHERE name='"+name+"'");
			Priority priority = null;
			while(rs.next()){
				priority = new Priority(rs.getInt("id"), rs.getString("name"), rs.getInt("value"));
			}

			statement.close();
			connection.close();
			return priority;

		}catch(ClassNotFoundException e){
			System.out.println("ClassNotFoundException");
		}
		catch(SQLException e){
			System.out.println("SQLException");
		}
		return null;
			}
	
	
	public static ArrayList<Priority> displayList(){
		try{
			ArrayList<Priority> priorities = new ArrayList<Priority>();
			Connection connection = (new Driver()).getConnection();
			Statement statement = connection.createStatement();
			Priority Priority;
			ResultSet rs = statement.executeQuery("SELECT * from priority");
			
			while(rs.next()){			
				Priority item= new Priority(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getInt("value"));
				priorities.add(item);
			}
			return priorities;
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
	