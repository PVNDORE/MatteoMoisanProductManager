package fr.imie.productmanager.dao;

import java.util.ArrayList;
import java.util.List;

import fr.imie.productmanager.entity.Product;

public class OldProductDao {
	
	static ArrayList<Product> myProductList = new ArrayList<Product>();
	static Long i = 0L;
	
	public static List<Product> getAllProducts() {		
		return myProductList;
	}
	
	public static void addProduct(Product myProduct) {
		myProduct.setId(++i);	
		myProductList.add(myProduct);
	}
	
	public static Product findProduct(Long id) {		
		for (Product myProduct : myProductList) {
	        if (myProduct.getId().equals(id)) {
	            return myProduct;
	        }
	    }
		
	    return null;
	}
	
	public static void removeProduct(Long id) {
		//TODO if findProduct is null
		Product myProduct = findProduct(id);		
		myProductList.remove(myProduct);
	}
}
