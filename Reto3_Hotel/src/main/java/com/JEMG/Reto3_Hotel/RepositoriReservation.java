package com.JEMG.Reto3_Hotel;

import java.util.Date;
import java.util.ArrayList;
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
	
	public void delete(Reservations reservation) {
		
		crud.delete(reservation);
	}
	
	public List<Reservations> getReservationsByClient(String client){
		return crud.findAllByStatus(client);
	}
	
	
	public List<Reservations> getReservationsPeriod(Date dateOne, Date dateTwo){
		
		return crud.findAllByStartDateAfterAndStartDateBefore(dateOne, dateTwo);
	}
	
	
	public List<CountClient> getTopClient(){
		
		List<CountClient> res=new ArrayList<>();
		
		List<Object[]> report=crud.countReservationsByClient();
		
		for(int i=0; i<report.size();i++) {
			//Client client=(Client) report.get(i)[0];
			//Long total=(Long) report.get(i)[0];
			//CountClient cc=new CountClient(total, client);
			//res.add(cc);
			
		res.add(new CountClient((Long) report.get(i)[1],(Client)report.get(i)[0]));
		}
				
		return res;
	}

}
