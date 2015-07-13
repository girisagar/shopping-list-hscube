package com.user.items;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import driver.Driver;

public class ItemController {
	public static ArrayList<Item> displayList() {
		try {
			ArrayList<Item> items = new ArrayList<Item>();
			Connection connection = (new Driver()).getConnection();
			Statement statement = connection.createStatement();
			Category category;
			ResultSet rs = statement.executeQuery("SELECT * from item");

			while (rs.next()) {

				Item item = new Item(rs.getInt("id"), rs.getString("name"),
						CategoryController.getCategory(rs.getInt("category")),
						PriorityController.getPriority(rs.getInt("priority")),
						rs.getInt("quantity"));
				items.add(item);
			}
			return items;
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException");
		} catch (SQLException e) {
			System.out.println("SQLException");
		}
		return null;
	}

	public static boolean deleteItems(ArrayList<Integer> ids) {
		if (ids.size() == 0) {
			return false;
		}

		try {
			java.sql.Connection connection = (new Driver()).getConnection();
			Statement statment = connection.createStatement();

			Iterator<Integer> iterator = ids.iterator();

			while (iterator.hasNext()) {
				int id = iterator.next();
				statment.execute("DELETE FROM  " + DbText.itemTable
						+ " WHERE id = " + id);
				statment.execute("DELETE FROM  " + DbText.wishItemTable
						+ " WHERE item_id = " + id);
			}

			connection.close();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static Item getItem(int id) {
		// add new item to table
		try {
			Connection connection = (new Driver()).getConnection();
			Statement statement = connection.createStatement();

			ResultSet rs = statement
					.executeQuery("SELECT * from item WHERE id=" + id);
			
			Item item = null;
			while (rs.next()) {
				item = new Item(rs.getInt("id"), rs.getString("name"),
						CategoryController.getCategory(rs.getInt("category")),
						PriorityController.getPriority(rs.getInt("priority")),
						rs.getInt("quantity"));
			}
			connection.close();
			statement.close();
			return item;
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException");
		} catch (SQLException e) {
			System.out.println("SQLException");
		}
		return null;

	}

}
