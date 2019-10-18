package com.khaled.chatbot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.khaled.chatbot.model.Conversation;
import com.khaled.chatbot.model.ResponseObj;
import com.khaled.chatbot.repository.ConversationRepository;
import com.khaled.chatbot.service.ChatService;
import com.khaled.chatbot.service.MasterActions;

import org.springframework.util.NumberUtils;

import org.deeplearning4j.models.embeddings.wordvectors.*;
import org.deeplearning4j.models.word2vec.*;
@RestController
public class ChatController {

	@Autowired
	ChatService chatservice;
	
	@Autowired
	MasterActions masteraction;
	
	@Autowired
	ConversationRepository conv_rep;
	
	 @RequestMapping({"chat"})
	 public ResponseObj chat(HttpServletRequest request, HttpServletResponse response )
	  {
		 ResponseObj responseObj = new ResponseObj();
 
		long conversation_id = NumberUtils.parseNumber( request.getParameter("conversation_id"), Long.class); 
		if(conversation_id <0) {
			Conversation conv = chatservice.StartConversation(1);
			conversation_id = conv.getId(); // create new conversation // arabic default
			String msg = masteraction.send_welcome_msg(conv);
			responseObj.setConversation_id(conversation_id);
			responseObj.setMessege(msg);
		}else {
		Conversation conv = conv_rep.findById(conversation_id).orElse(null);
		conv.getStory_detail();
			
		}
		
		return responseObj;
		 
	  }
}
