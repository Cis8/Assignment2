////////////////////////////////////////////////////////////////////
// EMANUELE CISOTTO 1161514
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import it.unipd.tos.business.SandwichShopManager;
import it.unipd.tos.business.exception.TakeAwayBillException;

import static org.junit.Assert.*;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.MenuItem.itemType;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class SandwichShopManagerTest {

    private SandwichShopManager manager = new SandwichShopManager();
    private ArrayList<MenuItem> itemsOrdered;

    private MenuItem primavera = new MenuItem(itemType.Panini, "Primavera", 4.50d);
    private MenuItem salsiccia = new MenuItem(itemType.Panini, "Salsiccia", 5.50d);
    private MenuItem salame = new MenuItem(itemType.Panini, "Salame", 5.00d);
    private MenuItem mozzarella = new MenuItem(itemType.Panini, "Mozzarella", 3.50d);
    private MenuItem prosciutto = new MenuItem(itemType.Panini, "Prosciutto", 4.00d);
    private MenuItem olive_ascolane = new MenuItem(itemType.Fritti, "Olive ascolane", 3.00d);

    @Before
    public void reset_itemsOrdered() {
        itemsOrdered = new ArrayList<MenuItem>();
    }
    
    @Test
    public void test_totale_base_case() throws TakeAwayBillException {
        itemsOrdered.addAll(Arrays.asList(primavera, salsiccia, olive_ascolane));
        assertEquals(13.00d, manager.getOrderPrice(itemsOrdered), 0.00d);
    }

    @Test
    public void test_totale_moreThan5Sandwiches() throws TakeAwayBillException {
        itemsOrdered.addAll(
                Arrays.asList(mozzarella, primavera, salsiccia, salame, olive_ascolane, prosciutto, mozzarella));
        assertEquals(27.25d, manager.getOrderPrice(itemsOrdered), 0.00d);
    }

    @Test
    public void test_totale_moreThan50euros() throws TakeAwayBillException {
        itemsOrdered.addAll(Arrays.asList(salsiccia, salsiccia, salsiccia, salsiccia, salsiccia, salsiccia, salsiccia,
                salsiccia, salsiccia, salsiccia));
        assertEquals(46.75d, manager.getOrderPrice(itemsOrdered), 0.00d);
    }

    @Test(expected = TakeAwayBillException.class)
    public void test_piu30item_eccezione() throws TakeAwayBillException {
        itemsOrdered.addAll(Arrays.asList(salsiccia, salsiccia, salsiccia, salsiccia, salsiccia, salsiccia, salsiccia, salsiccia, salsiccia, salsiccia, salsiccia, salsiccia, salsiccia, salsiccia, salsiccia, salsiccia, salsiccia, salsiccia, salsiccia, salsiccia, salsiccia, salsiccia, salsiccia, salsiccia, salsiccia, salsiccia, salsiccia, salsiccia, salsiccia, salsiccia, salsiccia, salsiccia, salsiccia, salsiccia, salsiccia, salsiccia, salsiccia, salsiccia));
        manager.getOrderPrice(itemsOrdered);
    }
    
    @Test
    public void test_commissione_50cent_con_meno_10euro_ordinazione() throws TakeAwayBillException {
        itemsOrdered.addAll(Arrays.asList(salsiccia, olive_ascolane));
        assertEquals(9.00d, manager.getOrderPrice(itemsOrdered), 0.00d);
    }
}
