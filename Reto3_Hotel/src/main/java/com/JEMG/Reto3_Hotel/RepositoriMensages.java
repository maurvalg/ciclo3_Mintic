package com.JEMG.Reto3_Hotel;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositoriMensages {
	
	@Autowired
	private interfaceMensagges crud;
	
	public List<Menssages> getAll(){
		
		return (List<Menssages>) crud.findAll();
	}
	
	public Optional <Menssages> getMenssages(int id){
		
		return crud.findById(id);
	}
	
	public Menssages save(Menssages mensages) {
		
		return crud.save(mensages);
	}

}
