////////////////////////////////////////////////////////////////////
// EMANUELE CISOTTO 1161514
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import it.unipd.tos.business.exception.TakeAwayBillException;
import java.util.List;
import java.util.OptionalDouble;

import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.MenuItem.itemType;

public class SandwichShopManager implements TakeAwayBill{
@Override
public double getOrderPrice(List<MenuItem> itemsOrdered) throws TakeAwayBillException {
return subtotal(itemsOrdered) - discount_more5sandwiches(itemsOrdered) - discount_more50euros(itemsOrdered);
}
double subtotal(List<MenuItem> itemsOrdered)
{
return itemsOrdered.stream().mapToDouble(x -> x.getPrice()).sum();
}
double discount_more5sandwiches(List<MenuItem> itemsOrdered)
{
if(itemsOrdered.stream().filter(s -> s.getType() == itemType.Panini).count() > 5)
{
return (itemsOrdered.stream().filter(s -> s.getType() == itemType.Panini).mapToDouble(d -> d.getPrice()).min().orElse(0.00)) / 2.0;
}
return 0.0;
}
double discount_more50euros(List<MenuItem> itemsOrdered)
{
double partial = itemsOrdered.stream().mapToDouble(d -> d.getPrice()).sum();
if(partial > 50.0)
{
return partial * 0.1;
}
return 0.0;
}
}
