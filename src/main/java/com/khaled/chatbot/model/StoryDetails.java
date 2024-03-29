package com.khaled.chatbot.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="story_detail")
public class StoryDetails {
	 @Id
	private Long id;
	  
	 @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "story_id")
	    private Stories story;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "intent_recived")
	    private Intent intent;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "action_to_do")
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

	public Intent getIntent() {
		return intent;
	}

	public void setIntent(Intent intent) {
		this.intent = intent;
	}

	public Actions getAction() {
		return action;
	}

	public void setAction(Actions action) {
		this.action = action;
	}
	 
	 
	 
}
