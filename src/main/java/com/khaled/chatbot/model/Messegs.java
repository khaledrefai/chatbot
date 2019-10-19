package com.khaled.chatbot.model;

import javax.persistence.EmbeddedId;
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

	@EmbeddedId
	private MsgId msgId;


	  
	  private String msg;

	


	public MsgId getMsgId() {
		return msgId;
	}

	public void setMsgId(MsgId msgId) {
		this.msgId = msgId;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	  
}
