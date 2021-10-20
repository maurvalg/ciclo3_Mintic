package com.JEMG.Reto3_Hotel;




import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="rooms")
public class Rooms {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	private String name;
	private String hotel;
	private Integer stars;
	private String description;
	
	@ManyToOne//(optional=false)
	@JoinColumn(name="Categoryid")// , insertable=false, updatable=false)
	@JsonIgnoreProperties("rooms")
	private Category category;
	
	@OneToMany(cascade = {CascadeType.PERSIST}, mappedBy="room")
	@JsonIgnoreProperties("room")
	private List<Menssages> messages;

	@OneToMany(cascade = {CascadeType.PERSIST}, mappedBy="room")
	@JsonIgnoreProperties("room")
	private List<Reservations> reservations;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getHotel() {
		return hotel;
	}


	public void setHotel(String hotel) {
		this.hotel = hotel;
	}


	public Integer getStars() {
		return stars;
	}


	public void setStars(Integer stars) {
		this.stars = stars;
	}
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public List<Menssages> getMessages() {
		return messages;
	}


	public void setMessages(List<Menssages> messages) {
		this.messages = messages;
	}


	public List<Reservations> getReservations() {
		return reservations;
	}


	public void setReservations(List<Reservations> reservations) {
		this.reservations = reservations;
	}

	
	
}
