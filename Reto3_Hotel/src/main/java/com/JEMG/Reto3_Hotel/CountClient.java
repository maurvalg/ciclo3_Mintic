package com.JEMG.Reto3_Hotel;

public class CountClient {
	
	private Long total;
	//private Integer total;
	private Client client;
	
	
	public CountClient(Long total, Client client) {
		super();
		this.total = total;
		this.client = client;
	}
	// Get and Set
	public Long getTotal() {
		return total;	
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}

	
	
}
