package com.JEMG.Reto3_Hotel;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositoriReservation {
	
	@Autowired
	private interfaceReservations crud;
	
	public List<Reservations> getAll(){
		
		return (List<Reservations>) crud.findAll();
	}
	
	public Optional <Reservations> getReservation(int id){
		
		return crud.findById(id);
	}
	
	public Reservations save(Reservations reservation) {
		
		return crud.save(reservation);
	}

}
