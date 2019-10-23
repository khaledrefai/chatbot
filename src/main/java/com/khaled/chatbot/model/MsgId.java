package com.khaled.chatbot.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class MsgId implements Serializable  {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	

	public MsgId() {
		super();
	}


	public MsgId(long msgId, Languages language) {
		super();
		this.msgId = msgId;
		this.language = language;
	}

	@Column(name = "messege_id")
	private long msgId;
	

	  @ManyToOne(fetch = FetchType.LAZY )
	  @JoinColumn(name = "language_id" , referencedColumnName="id")
	  private Languages language;


	public long getMsgId() {
		return msgId;
	}


	public void setMsgId(long msgId) {
		this.msgId = msgId;
	}


	
	public Languages getLanguage() {
		return language;
	}


	public void setLanguage(Languages language) {
		this.language = language;
	}


	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MsgId)) return false;
        MsgId that = (MsgId) o;
        return Objects.equals(getLanguage().getId(), that.getLanguage().getId()) &&
                Objects.equals(getMsgId(), that.getMsgId());
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(getMsgId(), getLanguage().getId());
    }
	

}
