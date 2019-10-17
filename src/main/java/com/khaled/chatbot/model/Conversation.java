package com.khaled.chatbot.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="conversation")
public class Conversation {

	  @Id
	    @GeneratedValue
	    private Long id;
	  
	  @ManyToOne(fetch = FetchType.LAZY )
	    @JoinColumn(name = "language_id" , referencedColumnName="id")
    private Languages language;
	  
	  
	  public Languages getLanguage() {
		return language;
	}


	public void setLanguage(Languages language) {
		this.language = language;
	}


	@ManyToOne(fetch = FetchType.LAZY )
	    @JoinColumn(name = "last_story_id" , referencedColumnName="id")
      private Stories story;
	  
	  
		 @ManyToOne(fetch = FetchType.LAZY)
		    @JoinColumn(name = "last_action")
		    private Actions action;


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public Stories getStory() {
			return story;
		}


		public void setStory(Stories story) {
			this.story = story;
		}


		public Actions getAction() {
			return action;
		}


		public void setAction(Actions action) {
			this.action = action;
		}
		 
		 
}
