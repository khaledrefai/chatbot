package com.khaled.chatbot.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

 import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

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
}
