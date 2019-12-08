package it.unipd.tos.business;

import it.unipd.tos.business.exception.TakeAwayBillException;
import java.util.List;

import it.unipd.tos.model.MenuItem;

public class SandwichShopManager implements TakeAwayBill{
	@Override
	public double getOrderPrice(List<MenuItem> itemsOrdered) throws TakeAwayBillException {
		return subtotal(itemsOrdered);
	}
	
	double subtotal(List<MenuItem> itemsOrdered)
	{
		return itemsOrdered.stream().mapToDouble(x -> x.getPrice()).sum();
	}
}
