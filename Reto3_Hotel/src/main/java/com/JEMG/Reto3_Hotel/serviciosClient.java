package com.JEMG.Reto3_Hotel;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class serviciosClient {
	
	@Autowired
	private RepositoriClient metodosCrud;
	
	public List<Client> getAll(){
		return metodosCrud.getAll();
		
	}
	
	
	public Optional<Client> getClient(int idClient){
		
		return metodosCrud.getClient(idClient);
	}

	
	public Client save(Client client) {
		
		if (client.getIdClient() == null) {
			
			return metodosCrud.save(client);
		}else {
			
			Optional<Client> evt=metodosCrud.getClient(client.getIdClient());
			if(evt.isEmpty()) {
				
				return metodosCrud.save(client);
			}else {
				return client;
			}
		}
	}
	
	public Client update(Client client){
		if (client.getIdClient() !=null) {
			
			Optional<Client> element=metodosCrud.getClient(client.getIdClient());
			if (!element.isEmpty()) {
				
				if(client.getEmail() != null) {
					element.get().setEmail(client.getEmail());
				}
				if(client.getPassword() != null) {
					element.get().setPassword(client.getPassword());
				}
				if(client.getName() != null) {
					element.get().setName(client.getName());
				}
				if(client.getAge() != null) {
					element.get().setAge(client.getAge());
				}
		
				metodosCrud.save(element.get());
				return element.get();
			}else {
				return client;
			}
		}else {
			return client;
		}
		
	}
	
	public boolean deleteCliente (int clientId) {
		Boolean clientBoolean = getClient(clientId).map(client -> {
			metodosCrud.delete(client);
			return true;
			
		}).orElse(false);
		return clientBoolean;
	}
	


}
