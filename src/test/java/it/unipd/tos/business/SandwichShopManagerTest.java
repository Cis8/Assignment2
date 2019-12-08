package it.unipd.tos.business;


import it.unipd.tos.business.SandwichShopManager;
import it.unipd.tos.business.exception.TakeAwayBillException;

import static org.junit.Assert.*;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.MenuItem.itemType;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
public class SandwichShopManagerTest {

	private SandwichShopManager manager = new SandwichShopManager();
    private ArrayList<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
	
    private MenuItem primavera = new MenuItem(itemType.Panini, "Primavera", 4.50d);
    private MenuItem salsiccia = new MenuItem(itemType.Panini, "Salsiccia", 5.50d);
    private MenuItem olive_ascolane = new MenuItem(itemType.Fritti, "Olive ascolane", 3.00d);
    
	@Test
	public void test_totale_itemsAddedManually_base_case() throws TakeAwayBillException{
		itemsOrdered.addAll(Arrays.asList(primavera, salsiccia, olive_ascolane));
		assertEquals(13.00d, manager.getOrderPrice(itemsOrdered), 0.00d);
	}

}
