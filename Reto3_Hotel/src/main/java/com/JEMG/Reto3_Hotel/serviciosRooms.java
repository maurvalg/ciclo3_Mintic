package com.JEMG.Reto3_Hotel;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class serviciosRooms {
	
	@Autowired
	private RepositoriRooms metodosCrud;
	
	public List<Rooms> getAll(){
		return metodosCrud.getAll();
		
	}
	
	
	public Optional<Rooms> getRooms(int idRooms){
		
		return metodosCrud.getRooms(idRooms);
	}

	
	public Rooms save(Rooms rooms) {
		
		if (rooms.getId() == null) {
			
			return metodosCrud.save(rooms);
		}else {
			
			Optional<Rooms> evt=metodosCrud.getRooms(rooms.getId());
			if(evt.isEmpty()) {
				
				return metodosCrud.save(rooms);
			}else {
				return rooms;
			}
		}
	}
}
