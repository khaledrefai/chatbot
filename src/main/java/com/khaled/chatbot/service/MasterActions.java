package com.khaled.chatbot.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.khaled.chatbot.constants.Msgs;
import com.khaled.chatbot.model.Conversation;
import com.khaled.chatbot.model.MsgId;
import com.khaled.chatbot.model.SaptcoForm;
import com.khaled.chatbot.repository.CityRepository;
import com.khaled.chatbot.repository.ConversationRepository;
import com.khaled.chatbot.repository.MessegesRepository;
import com.khaled.chatbot.repository.saptcoFormRepository;
import com.khaled.chatbot.model.Languages;


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
		String msg = msg_rep.getOne(new MsgId(Msgs.WELCOME_MSG,conv.getLanguage())).getMsg();
 	 return msg;	
	}
	
	public String send_invalid_msg(Conversation conv) {
		String msg = msg_rep.getOne(new MsgId(Msgs.INVALID_MSG,conv.getLanguage())).getMsg();
 	 return msg;	
	}
	
	public String send_thanks_msg(Conversation conv) {
		String msg = msg_rep.getOne(new MsgId(Msgs.THANK_MSG,conv.getLanguage())).getMsg();
 	 return msg;	
	}
	
	public String  send_choose_start_city(Conversation conv) {
		String msg = msg_rep.getOne(new MsgId(Msgs.CHOOSE_START_CITY,conv.getLanguage())).getMsg();
	 	 return msg;
	}
	
	public String  send_choose_dest_city(Conversation conv) {
		String msg = msg_rep.getOne(new MsgId(Msgs.CHOOSE_DEST_CITY,conv.getLanguage())).getMsg();
			 	 return msg;
	}
	
	
	
	public String  send_comming_soon(Conversation conv) {
		String msg = msg_rep.getOne(new MsgId(Msgs.COMMING_SOON,conv.getLanguage())).getMsg();
return msg;
	}
	
	public String  send_choose_month(Conversation conv) {
		String msg = msg_rep.getOne(new MsgId(Msgs.CHOOSE_MONTH,conv.getLanguage())).getMsg();
	 	 return msg;
	}
	
	public String  send_choose_day_of_moth(Conversation conv) {
		String msg = msg_rep.getOne(new MsgId(Msgs.CHOOSE_DAY_OF_MONTH,conv.getLanguage())).getMsg();
	 	 return msg;
	}
	
public String  send_enter_fullname(Conversation conv) {
	String msg = msg_rep.getOne(new MsgId(Msgs.ENTER_FULLNAME,conv.getLanguage())).getMsg();
	 return msg;
}
public String  send_choose_trip(Conversation conv) {
	String msg = msg_rep.getOne(new MsgId(Msgs.CHOOSE_TRIP,conv.getLanguage())).getMsg();
 	 return msg;
}

public String  send_enter_phone(Conversation conv) {
	String msg = msg_rep.getOne(new MsgId(Msgs.ENTER_PHONE,conv.getLanguage())).getMsg();
 	 return msg;
}

public String  send_invalid_name(Conversation conv) {
	String msg = msg_rep.getOne(new MsgId(Msgs.ENTER_PHONE,conv.getLanguage())).getMsg();
	 return msg;
	}


public String  send_invalid_phone(Conversation conv) {
	String msg = msg_rep.getOne(new MsgId(Msgs.ENTER_PHONE,conv.getLanguage())).getMsg();
	 return msg;
	}

public String  send_confirm(Conversation conv) {
SaptcoForm sform =	saptco_rep.findByConversation(conv).get(0);

String start_name = ""; 
String dest_name = "";

String trip_info = "";
if(conv.getLanguage().getId()==1) {
	start_name = sform.getStart_city().getCityname_ar(); 
	dest_name =sform.getDest_city().getCityname_ar();
	trip_info = sform.getTrip().getTripDesc_ar();
}else {
	
	 start_name = sform.getStart_city().getCityname(); 
	 dest_name =sform.getDest_city().getCityname();
	 trip_info = sform.getTrip().getTripDesc();
	
}


String msg =  msg_rep.getOne(new MsgId(Msgs.RESERVE_INFO,conv.getLanguage())).getMsg()+ " \n ";
msg =msg +  msg_rep.getOne(new MsgId(Msgs.START_CITY,conv.getLanguage())).getMsg() +" : "+start_name+"  \n ";
msg = msg +  msg_rep.getOne(new MsgId(Msgs.DEST_CITY,conv.getLanguage())).getMsg() +" : "+ dest_name +" \n  ";




msg = msg + msg_rep.getOne(new MsgId(Msgs.DATE,conv.getLanguage())).getMsg()  +" : "+sform.getDay_of_moth()+"/"+sform.getMonth()+"/"+sform.getYear() + " \n ";
msg = msg +  msg_rep.getOne(new MsgId(Msgs.TRIP,conv.getLanguage())).getMsg()  +" : "+ trip_info+ " \n ";
msg = msg + msg_rep.getOne(new MsgId(Msgs.FULLNAME,conv.getLanguage())).getMsg() +" : "+sform.getUser_full_name() + "  \n ";
msg = msg + msg_rep.getOne(new MsgId(Msgs.PHONE,conv.getLanguage())).getMsg()   +" : "+sform.getUser_phone() + " \n ";
msg = msg + msg_rep.getOne(new MsgId(Msgs.PLEASE_CONFRIM,conv.getLanguage())).getMsg()  ;
	 return msg;
	}

public String  send_finish_thanks(Conversation conv) {
	SaptcoForm sform =	saptco_rep.findByConversation(conv).get(0);

	String msg =  msg_rep.getOne(new MsgId(Msgs.FINISH_THANK,conv.getLanguage())).getMsg()+  ": "+sform.getId();
	 return msg;
	}



}