package com.khaled.chatbot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="saptco_trips")
public class SaptcoTrips {

	
	 @Id
	    @GeneratedValue
	    private Long id;
	  
	  private String tripDesc;

	  private String tripDesc_ar;
	  


	public String getTripDesc_ar() {
		return tripDesc_ar;
	}

	public void setTripDesc_ar(String tripDesc_ar) {
		this.tripDesc_ar = tripDesc_ar;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTripDesc() {
		return tripDesc;
	}

	public void setTripDesc(String tripDesc) {
		this.tripDesc = tripDesc;
	}

 
	  
	  
}
