package com.wrox.helper;

public class Product {
	private static final long serialVersionUID = 1L;
	private static int nextId = 1;
	private int id;
	
	private String name;
	private String supplier;
	private double price;

	public Product(String name, String supplier, double price) 
	{
		this.id = nextId++;
		this.name = name;
		this.supplier = supplier;
		
		this.price = price;
	}

	public String toString()
	{
		return this.name + " by " + this.supplier;
	}

	
	
	public String getName() 
	{
		return name;
	}

	public String getSupplier() 
	{
		return supplier;
	}

	public double getPrice() 
	{
		return price;
	}

	public int getId() 
	{
		return this.id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
}
