package comparators;

import java.util.Comparator;

import com.user.items.Item;

public class ItemNameAscComparator implements Comparator<Item> {

	public int compare(Item item1, Item item2) {

		String itemName1 = item1.getName().toUpperCase();
		String itemName2 = item2.getName().toUpperCase();

		// ascending order
		return itemName2.compareTo(itemName1);

		// descending order
		// return fruitName2.compareTo(fruitName1);
	}

}

//public static Comparator<Item> ItemNameDesComparator = new Comparator<Item>() {
//
//	public int compare(Item item1, Item item2) {
//
//		String itemName1 = item1.getName().toUpperCase();
//		String itemName2 = item2.getName().toUpperCase();
//
//		 return itemName2.compareTo(itemName1);
//	}
//
//};
//
//public static Comparator<Item> ItemCategoryAscComparator = new Comparator<Item>() {
//
//	public int compare(Item item1, Item item2) {
//
//		String itemCategory1 = item1.getCategory().getName();
//		String itemCategory2 = item2.getCategory().getName();
//
//		// ascending order
//		return itemCategory1.compareTo(itemCategory2);
//	}
//};
//
//
//public static Comparator<Item> ItemCategoryDesComparator = new Comparator<Item>() {
//
//	public int compare(Item item1, Item item2) {
//
//		String itemCategory1 = item1.getCategory().getName();
//		String itemCategory2 = item2.getCategory().getName();
//		// descending order
//		 return itemCategory2.compareTo(itemCategory1);
//	}
//
//};
//
//public static Comparator<Item> ItemPriorityAscComparator = new Comparator<Item>() {
//
//	public int compare(Item item1, Item item2) {
//
//		String itemCategory1 = item1.getCategory().getName();
//		String itemCategory2 = item2.getCategory().getName();
//
//		// ascending order
//		return itemCategory1.compareTo(itemCategory2);
//	}
//};
//
//
//public static Comparator<Item> ItemPriorityDesComparator = new Comparator<Item>() {
//
//	public int compare(Item item1, Item item2) {
//
//		String itemCategory1 = item1.getCategory().getName();
//		String itemCategory2 = item2.getCategory().getName();
//		// descending order
//		 return itemCategory2.compareTo(itemCategory1);
//	}
//
//};