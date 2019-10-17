package com.khaled.chatbot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stories")
public class Stories {

	 @Id
	    @GeneratedValue
	    private Long id;
	  
	  private String storyname;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStoryname() {
		return storyname;
	}

	public void setStoryname(String storyname) {
		this.storyname = storyname;
	}
	  
	  
	  
}
