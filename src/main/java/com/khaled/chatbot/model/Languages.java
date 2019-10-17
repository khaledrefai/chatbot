package com.khaled.chatbot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="languages")
public class Languages {


	  @Id
	    @GeneratedValue
	    private Long id;
	  
	  private String lang_desc;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLang_desc() {
		return lang_desc;
	}

	public void setLang_desc(String lang_desc) {
		this.lang_desc = lang_desc;
	}
	  
	  
	  
}
