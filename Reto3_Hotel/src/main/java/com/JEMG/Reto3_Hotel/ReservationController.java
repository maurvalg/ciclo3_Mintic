package com.JEMG.Reto3_Hotel;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET ,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
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
	
	//RETO 4
	
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Reservations update(@RequestBody Reservations reservation) {
		
		return servicios.update(reservation);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public boolean delete(@PathVariable("id") int reservationId) {
		
		return servicios.deleteReservation(reservationId);
	}

	

    //RETO 5

    @GetMapping("/report-status")
    public DescriptionAmount getPapeleriaDescritionStatus(){
        return servicios.getStatusReport();
    }
	
    @GetMapping("/report-clients")
    public List<CountClient> getCountClient(){
        return servicios.getTopReport();
    }
    
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservations> getDatesReport(@PathVariable("dateOne")String d1, @PathVariable("dateTwo")String d2){
       return servicios.getReservationPeriod(d1, d2);
    }
	
}
