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
@RequestMapping("/api/Message")
public class MenssagesController {
	

	
	@Autowired
	private serviciosMenssages servicios;
	
	@GetMapping("/all")
	public List<Menssages> getMensagges(){
		return servicios.getAll();
	}
	
	
	@GetMapping("/{id}")
	public Optional<Menssages> getMenssage(@PathVariable("id") int id){
		return servicios.getMensagges(id);
		
	}
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Menssages save(@RequestBody Menssages mensage) {
		
		return servicios.save(mensage);
	}


}
