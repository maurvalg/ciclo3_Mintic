package com.JEMG.Reto3_Hotel;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositoriCategory {
	
	@Autowired
	private interfaceCategory crud;
	
	public List<Category> getAll(){
		
		return (List<Category>) crud.findAll();
	}
	
	public Optional <Category> getCategory(int id){
		
		return crud.findById(id);
	}
	
	public Category save(Category category) {
		
		return crud.save(category);
	}

}
