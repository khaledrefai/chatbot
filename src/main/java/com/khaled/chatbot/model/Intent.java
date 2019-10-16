package com.khaled.chatbot.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
 

@Entity
@Table(name="intent")
public class Intent {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
 
	@NotEmpty
    private String intentname;

	

    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getntentname() {
		return intentname;
	}

	public void setInentname(String inntentname) {
		this.intentname = intentname;
	}

	 
}
