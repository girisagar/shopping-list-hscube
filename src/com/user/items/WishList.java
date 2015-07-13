package com.user.items;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import driver.Driver;

public class WishList {
	private int id;
	private Item item;
	

	public WishList(int id, Item item) {
		this.id = id;
		this.item = item;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Item getitem() {
		return this.item;
	}

	public void setitem(Item item) {
		this.item = item;
	}

	public static void main(String[] args) {/*
											 * int[] i = new int[] { 1, 2 };
											 * Item itemdata= new Item();
											 * ArrayList<Item> item = new
											 * ArrayList<>();
											 * itemdata.setName("chocolate");
											 * itemdata.setId(22);;
											 * 
											 * item.add(itemdata);
											 * 
											 * try { new
											 * WishList().addItemForWishList
											 * (item); // new
											 * WishList().deleteItemFromWishList
											 * (i);
											 * 
											 * } catch (ClassNotFoundException
											 * e) { // TODO Auto-generated catch
											 * block e.printStackTrace(); }
											 * catch (SQLException e) { // TODO
											 * Auto-generated catch block
											 * e.printStackTrace(); }
											 */
	}

}