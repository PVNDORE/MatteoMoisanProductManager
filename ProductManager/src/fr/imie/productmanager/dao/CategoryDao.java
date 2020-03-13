package fr.imie.productmanager.dao;

import java.util.List;

import fr.imie.productmanager.entity.Category;

public interface CategoryDao {
	
	Category findCategoryById(Long id);
	
	List<Category> getAllCategories();
	
	void saveCategory(Category myCategory);	
}
