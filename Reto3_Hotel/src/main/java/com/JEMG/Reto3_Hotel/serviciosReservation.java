package com.JEMG.Reto3_Hotel;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class serviciosReservation {
	
	@Autowired
	private RepositoriReservation metodosCrud;
	
	public List<Reservations> getAll(){
		return metodosCrud.getAll();
		
	}
	
	
	public Optional<Reservations> getReservation(int idReservation){
		
		return metodosCrud.getReservation(idReservation);
	}

	
	public Reservations save(Reservations reservation) {
		
		if (reservation.getIdReservation() == null) {
			
			return metodosCrud.save(reservation);
		}else {
			
			Optional<Reservations> evt=metodosCrud.getReservation(reservation.getIdReservation());
			if(evt.isEmpty()) {
				
				return metodosCrud.save(reservation);
			}else {
				return reservation;
			}
		}
	}


}
