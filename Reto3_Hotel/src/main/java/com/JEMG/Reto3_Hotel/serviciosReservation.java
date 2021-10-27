package com.JEMG.Reto3_Hotel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	
	public Reservations update(Reservations reservation){
		if (reservation.getIdReservation() !=null) {
			
			Optional<Reservations> element=metodosCrud.getReservation(reservation.getIdReservation());
			if (!element.isEmpty()) {
				
				if(reservation.getStartDate() != null) {
					element.get().setStartDate(reservation.getStartDate());
				}
				if(reservation.getDevolutionDate() != null) {
					element.get().setDevolutionDate(reservation.getDevolutionDate());
				}
				if(reservation.getStatus() != null) {
					element.get().setStatus(reservation.getStatus());
				}
				metodosCrud.save(element.get());
				return element.get();
			}else {
				return reservation;
			}
		}else {
			return reservation;
		}
		
	}
	
	public boolean deleteReservation (int reservationId) {
		Boolean reservationBoolean = getReservation(reservationId).map(reservation -> {
			metodosCrud.delete(reservation);
			return true;
			
		}).orElse(false);
		return reservationBoolean;
	}
	

	public List<CountClient> getTopReport(){
		
		return metodosCrud.getTopClient();
	}
	
	
	public DescriptionAmount getStatusReport() {
		
		List<Reservations> completed=metodosCrud.getReservationsByClient("completed");
		List<Reservations> cancelled=metodosCrud.getReservationsByClient("Cancelled");
		
		
		DescriptionAmount descAmt=new DescriptionAmount(completed.size(), cancelled.size());
		return descAmt;
		
	}
	
	
	public List<Reservations> getReservationPeriod(String date1, String date2){
		
		SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
		
		Date dateOne=new Date();
		Date dateTwo=new Date();
		try {
			dateOne=parser.parse(date1);
			dateTwo=parser.parse(date2);
			
		}catch (ParseException e) {
			e.printStackTrace();
			
		}
		   if(dateOne.before(dateTwo)){
	            return metodosCrud.getReservationsPeriod(dateOne, dateTwo);
	        }else{
	            return new ArrayList<>();
	        }
		
	}

}
