package com.JEMG.Reto3_Hotel;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {
	

	@Autowired
	private serviciosReservation servicios;
	
	@GetMapping("/all")
	public List<Reservations> getReservation(){
		return servicios.getAll();
	}
	
	
	@GetMapping("/{id}")
	public Optional<Reservations> getReservation(@PathVariable("id") int id){
		return servicios.getReservation(id);
		
	}
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Reservations save(@RequestBody Reservations reservation) {
		
		return servicios.save(reservation);
	}

}
