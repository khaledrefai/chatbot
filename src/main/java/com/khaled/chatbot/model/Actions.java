package com.khaled.chatbot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="actions")
public class Actions {
	  @Id
	    @GeneratedValue
	    private Long id;
	  
	  private String action_method;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAction_method() {
		return action_method;
	}

	public void setAction_method(String action_method) {
		this.action_method = action_method;
	}
	  
	  
}
