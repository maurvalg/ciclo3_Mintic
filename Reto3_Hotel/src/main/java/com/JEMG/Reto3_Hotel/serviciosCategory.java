package com.JEMG.Reto3_Hotel;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class serviciosCategory {
	
	@Autowired
	private RepositoriCategory metodosCrud;
	
	public List<Category> getAll(){
		return metodosCrud.getAll();
		
	}
	
	
	public Optional<Category> getCategory(int idCategory){
		
		return metodosCrud.getCategory(idCategory);
	}

	
	public Category save(Category category) {
		
		if (category.getId() == null) {
			
			return metodosCrud.save(category);
		}else {
			
			Optional<Category> evt=metodosCrud.getCategory(category.getId());
			if(evt.isEmpty()) {
				
				return metodosCrud.save(category);
			}else {
				return category;
			}
		}
	}
	
	public Category update(Category category){
		if (category.getId() !=null) {
			
			Optional<Category> element=metodosCrud.getCategory(category.getId());
			if (!element.isEmpty()) {
				
				if(category.getName() != null) {
					element.get().setName(category.getName());
				}
				if(category.getDescription() != null) {
					element.get().setDescription(category.getDescription());
				}
				/*if(category.getRooms() != null) {
					element.get().setRooms(category.getRooms());
				}*/
				metodosCrud.save(element.get());
				return element.get();
			}else {
				return category;
			}
		}else {
			return category;
		}
		
	}
	
	public boolean deleteCategory (int categoryId) {
		Boolean catBoolean = getCategory(categoryId).map(category -> {
			metodosCrud.delete(category);
			return true;
			
		}).orElse(false);
		return catBoolean;
	}
	

}
