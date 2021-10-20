package com.JEMG.Reto3_Hotel;


import java.io.Serializable;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name="messages")
public class Menssages implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer idMessage;
	private String messageText;
	
	
	@ManyToOne//(optional=false)
	@JoinColumn(name="id")//, insertable=false, updatable=false)
	@JsonIgnoreProperties({"messages", "reservations"})
	
	private Rooms room; //no es una lista

	
	@ManyToOne//(optional=false)
	@JoinColumn(name="idClient")// , insertable=false, updatable=false)
	@JsonIgnoreProperties({"messages", "reservations"})
	private Client client; //no es una lista


	//Get and Set
	public Integer getIdMessage() {
		return idMessage;
	}


	public void setIdMessage(Integer idMessage) {
		this.idMessage = idMessage;
	}


	public String getMessageText() {
		return messageText;
	}


	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}


	public Rooms getRoom() {
		return room;
	}


	public void setRoom(Rooms room) {
		this.room = room;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}




}
