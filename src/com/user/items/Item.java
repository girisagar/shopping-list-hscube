package com.user.items;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import driver.Driver;

public class Item {
	private int id;
	private String name;
	private Category category;
	private Priority priority;
	private int quantity;

	public Item(int id, String name, Category category, Priority priority,
			int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.priority = priority;
		this.quantity = quantity;
	}

	public boolean addItem() {
		// add new item to table
		try {
			Connection connection = (new Driver()).getConnection();
			Statement statement = connection.createStatement();
			String sql = "INSERT INTO item (name, category, priority, quantity) values("
					+ "'"
					+ this.getName()
					+ "'"
					+ ","
					+ this.getCategory().getId()
					+ "," + this.getPriority().getId() + "," + this.quantity + ")";
			System.out.println(sql);
			int value = statement.executeUpdate(sql);
			
			System.out.println(value);
			connection.close();
			statement.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean removeItem() throws ClassNotFoundException, SQLException {
		// remove item based on id
		Connection connection = (new Driver()).getConnection();
		Statement statement = connection.createStatement();
		statement.executeUpdate("DELETE item  WHERE id=" + this.id);
		connection.close();
		statement.close();
		return true;
	}

	public boolean updateItem() throws ClassNotFoundException, SQLException {
		// update row of item table with id
		Connection connection = (new Driver()).getConnection();
		Statement statement = connection.createStatement();
		statement.executeUpdate("UPDATE item SET" + "name=" + this.getName()
				+ "," + "category=" + this.getCategory().getId() + ","
				+ "priority=" + this.getPriority().getId() + "," + "quantity="
				+ this.quantity + "WHERE id=" + this.id);
		connection.close();
		statement.close();
		return true;
	}

	public static Comparator<Item> ItemNameAscComparator = new Comparator<Item>() {

		public int compare(Item item1, Item item2) {

			String itemName1 = item1.getName().toUpperCase();
			String itemName2 = item2.getName().toUpperCase();

			// ascending order
			return itemName1.compareTo(itemName2);

			// descending order
			// return fruitName2.compareTo(fruitName1);
		}

	};
	
	public static Comparator<Item> ItemNameDesComparator = new Comparator<Item>() {

		public int compare(Item item1, Item item2) {

			String itemName1 = item1.getName().toUpperCase();
			String itemName2 = item2.getName().toUpperCase();

			 return itemName2.compareTo(itemName1);
		}

	};
	
	public static Comparator<Item> ItemCategoryAscComparator = new Comparator<Item>() {

		public int compare(Item item1, Item item2) {

			String itemCategory1 = item1.getCategory().getName();
			String itemCategory2 = item2.getCategory().getName();

			// ascending order
			return itemCategory1.compareTo(itemCategory2);
		}
	};
	
	
	public static Comparator<Item> ItemCategoryDesComparator = new Comparator<Item>() {

		public int compare(Item item1, Item item2) {

			String itemCategory1 = item1.getCategory().getName();
			String itemCategory2 = item2.getCategory().getName();
			// descending order
			 return itemCategory2.compareTo(itemCategory1);
		}

	};
	
	public static Comparator<Item> ItemPriorityAscComparator = new Comparator<Item>() {

		public int compare(Item item1, Item item2) {

			String itemCategory1 = item1.getCategory().getName();
			String itemCategory2 = item2.getCategory().getName();

			// ascending order
			return itemCategory1.compareTo(itemCategory2);
		}
	};
	
	
	public static Comparator<Item> ItemPriorityDesComparator = new Comparator<Item>() {

		public int compare(Item item1, Item item2) {

			String itemCategory1 = item1.getCategory().getName();
			String itemCategory2 = item2.getCategory().getName();
			// descending order
			 return itemCategory2.compareTo(itemCategory1);
		}

	};
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Name = " + this.name + " category= " + this.category.getId()
				+ " priority =" + this.priority.getId() + " quantity= "
				+ this.quantity;
	}

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		Category cat = new Category(1, "new");
		Priority pr = new Priority(1, "high", 1);
		Item item = new Item(1, "Water Bottle", cat, pr, 1);
		ArrayList<Item> items = ItemController.displayList();
		Iterator it = items.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}