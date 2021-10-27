package com.JEMG.Reto3_Hotel;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface interfaceReservations extends CrudRepository<Reservations, Integer>{
	
	@Query("select c.client, COUNT(c.client) From Reservations AS c group by c.client order by COUNT(c.client) desc")
	public List<Object[]> countReservationsByClient();
	
	public List<Reservations> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
	
	public List<Reservations> findAllByStatus(String status);

}
