package comparators;

import java.util.Comparator;

import com.user.items.Item;

public class ItemPriorityAscComparator implements Comparator<Item> {

	public int compare(Item item1, Item item2) {

		int itemCategory1 = item1.getPriority().getValue();
		int itemCategory2 = item2.getPriority().getValue();
		// descending order
		 return (itemCategory2 -itemCategory1);
	}
}
