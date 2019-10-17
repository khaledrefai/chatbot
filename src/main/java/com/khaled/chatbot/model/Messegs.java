package com.khaled.chatbot.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="messeges")
public class Messegs {

	  @Id
	  private Long id;
	  
	  @ManyToOne(fetch = FetchType.LAZY )
	    @JoinColumn(name = "language_id" , referencedColumnName="id")
  private Languages language;
	  
	  private String msg;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Languages getLanguage() {
		return language;
	}

	public void setLanguage(Languages language) {
		this.language = language;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	  
}
