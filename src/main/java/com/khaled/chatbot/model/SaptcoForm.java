package com.khaled.chatbot.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="saptco_form")
public class SaptcoForm {

	  @Id
	    @GeneratedValue
	    private Long id;
	  
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "start_city")
    private City start_city;
	
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dest_city")
    private City dest_city;
    
    @Min(value = 1)
    @Max(value = 12)
    private int month;
    
    @Min(value = 1)  
    @Max(value = 31)
    private int day_of_moth;
    
    @Min(value = 2019)
    private int year;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id")
    private SaptcoTrips trip;
    
    @Length(min = 3, max = 35)
    private String user_full_name ;
    
    @Length(min = 6, max = 15)
    private String user_phone;
}
