package com.JEMG.Reto3_Hotel;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="client")
public class Client implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idClient;
	private String email;
	private String password;
	private String name;
	private Integer age;

	@OneToMany(cascade = {CascadeType.PERSIST}, mappedBy="client")
	@JsonIgnoreProperties({"messages", "client"})
	private List<Menssages> messages;

	@OneToMany(cascade = {CascadeType.PERSIST}, mappedBy="client")
	@JsonIgnoreProperties({"reservations", "client", "messages"})
	private List<Reservations> reservations;

	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


		public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
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
