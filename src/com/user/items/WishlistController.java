package com.user.items;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import driver.Driver;

public class WishlistController {

	public static boolean deleteItemFromWishList(ArrayList<Integer> ids) {

		try {
			java.sql.Connection connection = (new Driver()).getConnection();
			Statement statment = connection.createStatement();

			Iterator<Integer> iterator = ids.iterator();

			while (iterator.hasNext()) {
				statment.execute("DELETE FROM  " + DbText.wishItemTable
						+ " WHERE id = " + iterator.next());
			}

			connection.close();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean addItemForWishList(ArrayList<Integer> item) {
		
		if(item.size() == 0) {
			return false;
		}
		
		try {
			java.sql.Connection connection = (new Driver()).getConnection();
			Statement statment = connection.createStatement();
			Iterator<Integer> iterator = item.iterator();

			while (iterator.hasNext()) {
				statment.execute("INSERT IGNORE INTO " + DbText.wishItemTable + " ("
						+ DbText.wishlistItemId + ") VALUES ('" + iterator.next()
						+ "')");
			}
			connection.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	
	
	public static ArrayList<WishList> displayList(){
		try{
			ArrayList<WishList> w = new ArrayList<WishList>();
			Connection connection = (new Driver()).getConnection();
			Statement statement = connection.createStatement();
			Category category;
			ResultSet rs = statement.executeQuery("SELECT * from wishlist");
			
			while(rs.next()){
				
				WishList wishLists= new WishList(rs.getInt("id"), ItemController.getItem(rs.getInt("item_id")));
				
				w.add(wishLists);
			}
			return w;
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
