////////////////////////////////////////////////////////////////////
// EMANUELE CISOTTO 1161514
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;

public class MenuItem {
	public enum itemType{
		Panini, Fritti, Bevande;
	}
	
	private itemType type;
	
	private String name;
	
	private Double price;
	
	public MenuItem(itemType _type, String _name, double _price)
	{
		type = _type;
		name = _name;
		price = _price;
	}
	
	public itemType getType()
	{
		return type;
	}
	
	public String getName()
	{
		return name;
	}
	
	public Double getPrice()
	{
		return price;
	}
}
