package com.JEMG.Reto3_Hotel;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name="reservations")
public class Reservations implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer idReservation;
	private Date startDate;
	private Date devolutionDate;
	private String status;
	//private String status = "created";
	
	
	@ManyToOne(optional=false)
	@JoinColumn(name="id")//, insertable=false, updatable=false)
	@JsonIgnoreProperties("reservations")
	private Rooms room; //no es una lista
	
	@ManyToOne(optional=false)
	@JoinColumn(name="idClient" )//, insertable=false, updatable=false)
	@JsonIgnoreProperties({"reservations", "messages"})
	private Client client; //no es una lista

	private String score;

	
	//Get and Set
	
	public Integer getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(Integer idReservation) {
		this.idReservation = idReservation;
	}

	public Date getStartDate() {
		return startDate;// + "T00:00:00.000+00:00";
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getDevolutionDate() {
		return devolutionDate; // + "T00:00:00.000+00:00";
	}

	public void setDevolutionDate(Date devolutionDate) {
		this.devolutionDate = devolutionDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	
	
	
}
