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
	
	public String send_invalid_msg(Conversation conv) {
		String msg = msg_rep.findByIdAndLanguage(Msgs.INVALID_MSG,conv.getLanguage()).get(0).getMsg();
 	 return msg;	
	}
	
	public String send_thanks_msg(Conversation conv) {
		
		String msg = msg_rep.findByIdAndLanguage(Msgs.THANK_MSG,conv.getLanguage()).get(0).getMsg();
 	 return msg;	
	}
	
	public String  send_choose_start_city(Conversation conv) {
		String msg = msg_rep.findByIdAndLanguage(Msgs.CHOOSE_START_CITY,conv.getLanguage()).get(0).getMsg();
	 	 return msg;
	}
	
	
	public String  send_comming_soon(Conversation conv) {
		String msg = msg_rep.findByIdAndLanguage(Msgs.COMMING_SOON,conv.getLanguage()).get(0).getMsg();
	 	 return msg;
	}
	
	public String  send_choose_month(Conversation conv) {
		String msg = msg_rep.findByIdAndLanguage(Msgs.CHOOSE_MONTH,conv.getLanguage()).get(0).getMsg();
	 	 return msg;
	}
	
	public String  send_choose_day_of_moth(Conversation conv) {
		String msg = msg_rep.findByIdAndLanguage(Msgs.CHOOSE_DAY_OF_MONTH,conv.getLanguage()).get(0).getMsg();
	 	 return msg;
	}
	
public String  send_enter_fullname(Conversation conv) {
	String msg = msg_rep.findByIdAndLanguage(Msgs.ENTER_FULLNAME,conv.getLanguage()).get(0).getMsg();
	 return msg;
}
public String  send_choose_trip(Conversation conv) {
	String msg = msg_rep.findByIdAndLanguage(Msgs.CHOOSE_TRIP,conv.getLanguage()).get(0).getMsg();
 	 return msg;
}

public String  send_enter_phone(Conversation conv) {
	String msg = msg_rep.findByIdAndLanguage(Msgs.ENTER_PHONE,conv.getLanguage()).get(0).getMsg();
 	 return msg;
}


}