package com.JEMG.Reto3_Hotel;

public class DescriptionAmount {
	
	private Integer completed;
	private Integer cancelled;
	

	
	
	public DescriptionAmount(Integer completed, Integer cancelled) {
		super();
		this.completed = completed;
		this.cancelled = cancelled;
	}
	
	
	
	public Integer getCompleted() {
		return completed;
	}
	public void setCompleted(Integer completed) {
		this.completed = completed;
	}
	public Integer getCancelled() {
		return cancelled;
	}
	public void setCancelled(Integer cancelled) {
		this.cancelled = cancelled;
	}
	
	

}
