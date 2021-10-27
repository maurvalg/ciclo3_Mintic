package com.JEMG.Reto3_Hotel;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class serviciosMenssages {
	@Autowired
	private RepositoriMensages metodosCrud;
	
	public List<Menssages> getAll(){
		return metodosCrud.getAll();
		
	}
	
	
	public Optional<Menssages> getMensagges(int idMenssage){
		
		return metodosCrud.getMenssages(idMenssage);
	}

	
	public Menssages save(Menssages mensage) {
		
		if (mensage.getIdMessage()== null) {
			
			return metodosCrud.save(mensage);
		}else {
			
			Optional<Menssages> evt=metodosCrud.getMenssages(mensage.getIdMessage());
			if(evt.isEmpty()) {
				
				return metodosCrud.save(mensage);
			}else {
				return mensage;
			}
		}
	}
	
	public Menssages update(Menssages mensage){
		if (mensage.getIdMessage() !=null) {
			
			Optional<Menssages> element=metodosCrud.getMenssages(mensage.getIdMessage());
			if (!element.isEmpty()) {
				
				if(mensage.getMessageText() != null) {
					element.get().setMessageText(mensage.getMessageText());
				}
				metodosCrud.save(element.get());
				return element.get();
			}else {
				return mensage;
			}
		}else {
			return mensage;
		}
		
	}
	
	public boolean deleteMessagee (int messageId) {
		Boolean messageBoolean = getMensagges(messageId).map(message -> {
			metodosCrud.delete(message);
			return true;
			
		}).orElse(false);
		return messageBoolean;
	}
	

}
