package comparators;

import java.util.Comparator;

import com.user.items.Item;

public class ItemNameDesComparator implements Comparator<Item> {

	public int compare(Item item1, Item item2) {

		String itemName1 = item1.getName().toUpperCase();
		String itemName2 = item2.getName().toUpperCase();

		// ascending order
		return  itemName1.compareTo(itemName2);
	}
}