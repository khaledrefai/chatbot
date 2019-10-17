package com.khaled.chatbot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.khaled.chatbot.constants.Msgs;
import com.khaled.chatbot.model.Conversation;
import com.khaled.chatbot.repository.ConversationRepository;
import com.khaled.chatbot.repository.MessegesRepository;;
 

@Component
public class MasterActions {
	
	@Autowired
	MessegesRepository msg_rep;
	
	@Autowired
	ConversationRepository conv_rep;
	
	public String send_welcome_msg(Conversation conv) {
		
		String msg = msg_rep.findByIdAndLanguage(Msgs.WELCOME_MSG,conv.getLanguage()).get(0).getMsg();
 	 return msg;	
	}
}
