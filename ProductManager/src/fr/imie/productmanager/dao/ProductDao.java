package fr.imie.productmanager.dao;

import java.util.List;

import fr.imie.productmanager.entity.Product;

public interface ProductDao {
	
	Product findProductById(Long id);
	
	List<Product> getAllProducts();
	
	void saveProduct(Product myProduct);	
	
	void removeProduct(Product myProduct);

}
