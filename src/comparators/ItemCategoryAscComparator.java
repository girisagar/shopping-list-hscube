package comparators;

import java.util.Comparator;

import com.user.items.Item;

public class ItemCategoryAscComparator  implements Comparator<Item> {

	public int compare(Item item1, Item item2) {

		String itemCategory1 = item1.getCategory().getName();
		String itemCategory2 = item2.getCategory().getName();

		// ascending order
		return itemCategory1.compareTo(itemCategory2);
	}
};