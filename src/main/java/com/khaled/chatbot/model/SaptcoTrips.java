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
	  
	  private String desc;
}
