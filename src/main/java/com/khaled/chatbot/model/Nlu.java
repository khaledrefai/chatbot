package com.khaled.chatbot.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

 import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name="nlu")
public class Nlu {

	  @Id
	    @GeneratedValue
	    private Long id;
	  
	  private String nlutext;
	  
 	  
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "intent_id")
	    private Intent intent;

	    

		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getNlutext() {
			return nlutext;
		}


		public void setNlutext(String nlutext) {
			this.nlutext = nlutext;
		}


		public Intent getIntent() {
			return intent;
		}


		public void setIntent(Intent intent) {
			this.intent = intent;
		}


	    
	    
}
