package com.khaled.chatbot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cities")
public class City {
	
	 @Id
	    @GeneratedValue
	    private Long id;
	  
	  private String cityname;
	  
	  private String cityname_ar;
	  
	  

	public String getCityname_ar() {
		return cityname_ar;
	}

	public void setCityname_ar(String cityname_ar) {
		this.cityname_ar = cityname_ar;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	  
	  
	  

}
