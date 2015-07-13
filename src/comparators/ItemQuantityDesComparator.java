package comparators;

import java.util.Comparator;

import com.user.items.Item;

public class ItemQuantityDesComparator implements Comparator<Item> {

	public int compare(Item item1, Item item2) {

		int itemQuantity1 = item1.getQuantity();
		int itemQuantity2 = item2.getQuantity();

		// descending order
		return itemQuantity2 - itemQuantity1;
	}
}