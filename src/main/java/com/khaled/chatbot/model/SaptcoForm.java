package com.khaled.chatbot.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
	  
	  
	  @OneToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "conversation_id")
	    private Conversation conversation;
	  
	  
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "start_city")
    private City start_city;
	
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dest_city")
    private City dest_city;
    

    private int month;
    
   
    private int day_of_moth;
    
    private int year;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id")
    private SaptcoTrips trip;
    
    private String user_full_name ;
    
    private String user_phone;

    private int is_canceled; 
    
    
	public int getIs_canceled() {
		return is_canceled;
	}

	public void setIs_canceled(int is_canceled) {
		this.is_canceled = is_canceled;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Conversation getConversation() {
		return conversation;
	}

	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}

	public City getStart_city() {
		return start_city;
	}

	public void setStart_city(City start_city) {
		this.start_city = start_city;
	}

	public City getDest_city() {
		return dest_city;
	}

	public void setDest_city(City dest_city) {
		this.dest_city = dest_city;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay_of_moth() {
		return day_of_moth;
	}

	public void setDay_of_moth(int day_of_moth) {
		this.day_of_moth = day_of_moth;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public SaptcoTrips getTrip() {
		return trip;
	}

	public void setTrip(SaptcoTrips trip) {
		this.trip = trip;
	}

	public String getUser_full_name() {
		return user_full_name;
	}

	public void setUser_full_name(String user_full_name) {
		this.user_full_name = user_full_name;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
    
    
    
    
}
