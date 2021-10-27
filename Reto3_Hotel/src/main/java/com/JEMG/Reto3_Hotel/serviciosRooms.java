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
	
	public Rooms update(Rooms room){
		if (room.getId() !=null) {
			
			Optional<Rooms> element=metodosCrud.getRooms(room.getId());
			if (!element.isEmpty()) {
				
				if(room.getName() != null) {
					element.get().setName(room.getName());
				}
				if(room.getHotel() != null) {
					element.get().setHotel(room.getHotel());
				}
				if(room.getStars() != null) {
					element.get().setStars(room.getStars());
				}
				if(room.getDescription() != null) {
					element.get().setDescription(room.getDescription());
				}
				if(room.getCategory() != null) {
					element.get().setCategory(room.getCategory());
				}
				/*if(category.getRooms() != null) {
					element.get().setRooms(category.getRooms());
				}*/
				metodosCrud.save(element.get());
				return element.get();
			}else {
				return room;
			}
		}else {
			return room;
		}
		
	}
	
	public boolean deleteRoom (int roomId) {
		Boolean roomBoolean = getRooms(roomId).map(room -> {
			metodosCrud.delete(room);
			return true;
			
		}).orElse(false);
		return roomBoolean;
	}
	
}
