package com.khaled.chatbot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khaled.chatbot.model.Conversation;
import com.khaled.chatbot.model.Languages;
import com.khaled.chatbot.repository.ConversationRepository;
import com.khaled.chatbot.repository.LanguageRepository;

@Service
public class ChatService {

	@Autowired
	ConversationRepository conversation_rep;
	
	@Autowired
	LanguageRepository languageRepository;
	
	public Conversation StartConversation(long langid) {
		Languages lang = languageRepository.getOne(langid);
		Conversation conv = new Conversation();
		conv.setLanguage(lang);
		  conversation_rep.save(conv);
		  
	 return conv;

	}
}
