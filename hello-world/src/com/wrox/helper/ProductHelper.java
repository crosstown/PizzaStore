package com.wrox.helper;

import java.util.ArrayList;
import java.util.List;

public class ProductHelper {
	
	    private List<Product> testProducts = new ArrayList<Product>();
		private static ProductHelper reference;

	    /**
	     * Use this method if you want to share the service across many servlets.
	     * 
	     * This is simulating what a true container such as Spring would provide
	     */
	    public static ProductHelper getService()
	    {
	    	if (reference == null)
	    		reference = new ProductHelper();
	    	return reference;
	    }
	    
	    public ProductHelper() 
	    {
	        Product prod1 = new Product("Beer", "Budweiser bottling", 10.99);
	        Product prod2 = new Product("Bread", "Whole G", 4.99);
	        Product prod3 = new Product("Wine", "Mendoza Winery", 16.99);
	        testProducts.add(prod1);
	        testProducts.add(prod2);
	        testProducts.add(prod3);
	    }

		public List<Product> getProductsByName(String name) 
		{
			List<Product> returnList = new ArrayList<Product>();
			for (Product next : testProducts)
			{
				if (next.getName().equals(name))
				{
					returnList.add(next);
				}
			}
			return returnList;	
		}

		public List<Product> getEntireList() 
		{
			return new ArrayList<Product>(testProducts);
		}

		public void registerNewProduct(Product newProd) 
		{
			testProducts.add(newProd);
		}
	    
		public List<Product> getAllProducysbySupplier(String supplier) 
		{
			List<Product> returnList = new ArrayList<Product>();
			for (Product next : testProducts)
			{
				if (next.getSupplier().equals(supplier))
				{
					returnList.add(next);
				}
			}
			return returnList;
		}

		public void deleteProductFromPreferences(Product prodToRemove) 
		{
			testProducts.remove(prodToRemove.getName());
		}
		
		public Product getProductById(int id)
		{
			for (Product next : testProducts)
			{
				if (next.getId() == id)
				{
					return next;
				}
			}
			return null;
		}
}
