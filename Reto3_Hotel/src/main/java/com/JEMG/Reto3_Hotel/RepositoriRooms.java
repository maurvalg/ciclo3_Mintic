package com.JEMG.Reto3_Hotel;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositoriRooms {
	
	@Autowired
	private interfaceRooms crud;
	
	public List<Rooms> getAll(){
		
		return (List<Rooms>) crud.findAll();
	}
	
	public Optional <Rooms> getRooms(int id){
		
		return crud.findById(id);
	}
	
	public Rooms save(Rooms rooms) {
		
		return crud.save(rooms);
	}
	
	public void delete(Rooms rooms) {
			
			crud.delete(rooms);
	}

}
