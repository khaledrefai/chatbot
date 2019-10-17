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
import com.khaled.chatbot.service.ChatService;

import org.springframework.util.NumberUtils;

@RestController
public class ChatController {
	
	@Autowired
	ChatService chatservice;
	
	 @RequestMapping({"chat"})
	 public String chat(HttpServletRequest request, HttpServletResponse response )
	  {
 
		long conversation_id = NumberUtils.parseNumber( request.getParameter("conversation_id"), Long.class); 
		if(conversation_id <0) {
			Conversation conv = chatservice.StartConversation(1);
			conversation_id = conv.getId(); // create new conversation // arabic default
		}else {
			
			
		}
		
		return null;
		 
	  }
}
