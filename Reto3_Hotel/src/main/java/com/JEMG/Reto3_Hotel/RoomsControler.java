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
@RequestMapping("/api/Room")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET ,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class RoomsControler {
	
	@GetMapping("/holaMundo")
	public String saludar() {
		return "Hola Mundo Tutoria Colombia";
	}

	
	@Autowired
	private serviciosRooms servicios;
	
	@GetMapping("/all")
	public List<Rooms> getRooms(){
		return servicios.getAll();
	}
	
	
	@GetMapping("/{id}")
	public Optional<Rooms> getRooms(@PathVariable("id") int id){
		return servicios.getRooms(id);
		
	}
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Rooms save(@RequestBody Rooms rooms) {
		
		return servicios.save(rooms);
	}
	
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Rooms update(@RequestBody Rooms roomId) {
		
		return servicios.update(roomId);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public boolean delete(@PathVariable("id") int roomId) {
		
		return servicios.deleteRoom(roomId);
	}
	
}
