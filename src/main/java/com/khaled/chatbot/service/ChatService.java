package com.khaled.chatbot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khaled.chatbot.model.City;
import com.khaled.chatbot.model.Conversation;
import com.khaled.chatbot.model.Languages;
import com.khaled.chatbot.model.SaptcoForm;
import com.khaled.chatbot.model.StoryDetails;
import com.khaled.chatbot.repository.CityRepository;
import com.khaled.chatbot.repository.ConversationRepository;
import com.khaled.chatbot.repository.LanguageRepository;
import com.khaled.chatbot.repository.StoryDetailsRepository;
import com.khaled.chatbot.repository.saptcoFormRepository;

@Service
public class ChatService {

	@Autowired
	ConversationRepository conversation_rep;
	
	@Autowired
	LanguageRepository languageRepository;
	
	@Autowired
	StoryDetailsRepository storydetails_rep;
	
	@Autowired
	saptcoFormRepository saptco_rep;
	
	@Autowired
	CityRepository city_rep;
	
	
	public Conversation StartConversation(long langid , long story_id) {
		Languages lang = languageRepository.getOne(langid);
		StoryDetails sd = storydetails_rep.getOne((long) 1);
		Conversation conv = new Conversation();
		conv.setLanguage(lang);
		conv.setStory_detail(sd);
		  conversation_rep.save(conv);
		  
	 return conv;

	}
	
	public void create_form(Conversation conv, long start_city_id) {
		SaptcoForm sform = new SaptcoForm();
		City city = city_rep.getOne(start_city_id);
		sform.setConversation(conv);
		sform.setStart_city(city);
		saptco_rep.save(sform);
	}
}
