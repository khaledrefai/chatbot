package com.khaled.chatbot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.khaled.chatbot.constants.Msgs;
import com.khaled.chatbot.model.Conversation;
import com.khaled.chatbot.model.SaptcoForm;
import com.khaled.chatbot.repository.CityRepository;
import com.khaled.chatbot.repository.ConversationRepository;
import com.khaled.chatbot.repository.MessegesRepository;
import com.khaled.chatbot.repository.saptcoFormRepository;;
 

@Component
public class MasterActions {
	
	@Autowired
	MessegesRepository msg_rep;
	
	@Autowired
	ConversationRepository conv_rep;
	
	@Autowired
	saptcoFormRepository saptco_rep;
	
	@Autowired
	CityRepository city_rep;
	
	
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
	
	public String  send_choose_dest_city(Conversation conv) {
		String msg = msg_rep.findByIdAndLanguage(Msgs.CHOOSE_DEST_CITY,conv.getLanguage()).get(0).getMsg();
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

public String  send_invalid_name(Conversation conv) {
	String msg = msg_rep.findByIdAndLanguage(Msgs.ENTER_PHONE,conv.getLanguage()).get(0).getMsg();
	 return msg;
	}


public String  send_invalid_phone(Conversation conv) {
	String msg = msg_rep.findByIdAndLanguage(Msgs.ENTER_PHONE,conv.getLanguage()).get(0).getMsg();
	 return msg;
	}

public String  send_confirm(Conversation conv) {
SaptcoForm sform =	saptco_rep.findByConversation(conv).get(0);
String msg = msg_rep.findByIdAndLanguage(Msgs.RESERVE_INFO,conv.getLanguage()).get(0).getMsg()+"\n";
msg = msg_rep.findByIdAndLanguage(Msgs.START_CITY,conv.getLanguage()).get(0).getMsg()+" : "+sform.getStart_city().getCityname()+"\n";
msg = msg_rep.findByIdAndLanguage(Msgs.DEST_CITY,conv.getLanguage()).get(0).getMsg()+" : "+sform.getDest_city().getCityname()+"\n";
msg = msg_rep.findByIdAndLanguage(Msgs.DATE,conv.getLanguage()).get(0).getMsg()+" : "+sform.getDay_of_moth()+"/"+sform.getMonth()+"/2019" + "\n";
msg = msg_rep.findByIdAndLanguage(Msgs.TRIP,conv.getLanguage()).get(0).getMsg()+" : "+sform.getTrip().getTripDesc() + "\n";
msg = msg_rep.findByIdAndLanguage(Msgs.FULLNAME,conv.getLanguage()).get(0).getMsg()+" : "+sform.getUser_full_name() + "\n";
msg = msg_rep.findByIdAndLanguage(Msgs.PHONE,conv.getLanguage()).get(0).getMsg()+" : "+sform.getUser_phone() + "\n";
msg = msg_rep.findByIdAndLanguage(Msgs.PLEASE_CONFRIM,conv.getLanguage()).get(0).getMsg();
	 return msg;
	}

public String  send_finish_thanks(Conversation conv) {
	SaptcoForm sform =	saptco_rep.findByConversation(conv).get(0);

	String msg = msg_rep.findByIdAndLanguage(Msgs.FINISH_THANK,conv.getLanguage()).get(0).getMsg()+": "+sform.getId();
	 return msg;
	}



}