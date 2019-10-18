package com.khaled.chatbot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.khaled.chatbot.model.City;
import com.khaled.chatbot.model.Conversation;
import com.khaled.chatbot.model.ResponseObj;
import com.khaled.chatbot.model.SaptcoForm;
import com.khaled.chatbot.model.StoryDetails;
import com.khaled.chatbot.repository.CityRepository;
import com.khaled.chatbot.repository.ConversationRepository;
import com.khaled.chatbot.repository.StoryDetailsRepository;
import com.khaled.chatbot.repository.saptcoFormRepository;
import com.khaled.chatbot.service.ChatService;
import com.khaled.chatbot.service.MasterActions;
import com.khaled.chatbot.service.NlpService;

@RestController
public class ChatController {

	@Autowired
	ChatService chatservice;

	@Autowired
	MasterActions masteraction;

	@Autowired
	ConversationRepository conv_rep;

	@Autowired
	NlpService nlpservice;

	@Autowired
	StoryDetailsRepository story_details_rep;

	@Autowired
	saptcoFormRepository sapt_rep;
	
	@Autowired
	CityRepository city_rep;
	
	@RequestMapping({ "chat" })
	public ResponseObj chat(HttpServletRequest request, HttpServletResponse response) {
		ResponseObj responseObj = new ResponseObj();

		long conversation_id = NumberUtils.toInt(request.getParameter("conversation_id"), -1);

		String messege = request.getParameter("messege");

		if (conversation_id <= 0) {
			Conversation conv = chatservice.StartConversation(nlpservice.get_text_lang(messege), 1); // story 1
			conversation_id = conv.getId(); // create new conversation
			String msg = masteraction.send_welcome_msg(conv);
			responseObj.setConversation_id(conversation_id);
			responseObj.setMessege(msg);
		} else {
			Conversation conv = conv_rep.getOne(conversation_id);
			StoryDetails storydetails = conv.getStory_detail();
			int req_num = NumberUtils.toInt(messege, -1);

			if (req_num == 0) { // request to cancel
				String msg = masteraction.send_thanks_msg(conv);
				responseObj.setConversation_id(0);
				responseObj.setMessege(msg);
				return responseObj;
			} else if (storydetails.getId() == 1) { // second user msg we excpect to choose between 1 and 3 or 0
				if (req_num < 0) { // invalid
					String msg = masteraction.send_invalid_msg(conv);
					responseObj.setConversation_id(conversation_id);
					responseObj.setMessege(msg);
				} else if (req_num == 1) { // start new reservation
					String msg = masteraction.send_choose_start_city(conv);
					responseObj.setConversation_id(conversation_id);
					responseObj.setMessege(msg);
					StoryDetails story_detail2 = story_details_rep.getOne((long) 2);
					conv.setStory_detail(story_detail2); // move to next
					conv_rep.save(conv);
				} else if (req_num > 1) { // comming soon
					String msg = masteraction.send_comming_soon(conv);
					responseObj.setConversation_id(conversation_id);
					responseObj.setMessege(msg);
					StoryDetails story_detail2 = story_details_rep.getOne((long) 2);
					conv.setStory_detail(story_detail2); // move to next
					conv_rep.save(conv);
				}
			} else if (storydetails.getId() == 2) { // filling form add start city
				if (req_num > 0 && req_num < 5) { // valid city
					chatservice.create_form(conv, req_num);  // create form 
					String msg = masteraction.send_choose_dest_city(conv);
					responseObj.setConversation_id(conversation_id);
					responseObj.setMessege(msg);
					StoryDetails story_detail2 = story_details_rep.getOne((long) 3);
					conv.setStory_detail(story_detail2); // move to next
					conv_rep.save(conv);
				} else {
					String msg = masteraction.send_invalid_msg(conv);
					responseObj.setConversation_id(conversation_id);
					responseObj.setMessege(msg);
				}
			} else if (storydetails.getId() == 3) { // filling form add dest city
				if (req_num > 0 && req_num < 5) { // valid city
					chatservice.create_form(conv, req_num);
					SaptcoForm sform =  sapt_rep.findByConversation(conv).get(0);
					City city = city_rep.getOne((long) req_num);
					sform.setDest_city(city);
					sapt_rep.save(sform);
					String msg = masteraction.send_choose_month(conv);
					responseObj.setConversation_id(conversation_id);
					responseObj.setMessege(msg);
					StoryDetails story_detail2 = story_details_rep.getOne((long) 4);
					conv.setStory_detail(story_detail2); // move to next
					conv_rep.save(conv);
				} else {
					String msg = masteraction.send_invalid_msg(conv);
					responseObj.setConversation_id(conversation_id);
					responseObj.setMessege(msg);
				}
			}
			 else if (storydetails.getId() == 4) { // filling form add month
					if (req_num > 0 && req_num < 13) { // valid month
						SaptcoForm sform =  sapt_rep.findByConversation(conv).get(0);
						sform.setMonth(req_num);
						sapt_rep.save(sform);
						String msg = masteraction.send_choose_day_of_moth(conv);
						responseObj.setConversation_id(conversation_id);
						responseObj.setMessege(msg);
						StoryDetails story_detail2 = story_details_rep.getOne((long) 5);
						conv.setStory_detail(story_detail2); // move to next
						conv_rep.save(conv);
					} else {
						String msg = masteraction.send_invalid_msg(conv);
						responseObj.setConversation_id(conversation_id);
						responseObj.setMessege(msg);
					}
				} else if (storydetails.getId() == 5) { // filling form add day month
					if (req_num > 0 && req_num < 32) { // valid month
						SaptcoForm sform =  sapt_rep.findByConversation(conv).get(0);
						sform.setDay_of_moth(req_num);
						sapt_rep.save(sform);
						String msg = masteraction.send_choose_trip(conv);
						responseObj.setConversation_id(conversation_id);
						responseObj.setMessege(msg);
						StoryDetails story_detail2 = story_details_rep.getOne((long) 6);
						conv.setStory_detail(story_detail2); // move to next
						conv_rep.save(conv);
					} else {
						String msg = masteraction.send_invalid_msg(conv);
						responseObj.setConversation_id(conversation_id);
						responseObj.setMessege(msg);
					}
				} else if (storydetails.getId() == 6) { // filling form 
					if (req_num > 0 && req_num < 11) { // valid 
						SaptcoForm sform =  sapt_rep.findByConversation(conv).get(0);
						sform.setDay_of_moth(req_num);
						sapt_rep.save(sform);
						String msg = masteraction.send_choose_trip(conv);
						responseObj.setConversation_id(conversation_id);
						responseObj.setMessege(msg);
						StoryDetails story_detail2 = story_details_rep.getOne((long) 6);
						conv.setStory_detail(story_detail2); // move to next
						conv_rep.save(conv);
					} else {
						String msg = masteraction.send_invalid_msg(conv);
						responseObj.setConversation_id(conversation_id);
						responseObj.setMessege(msg);
					}
				}

		}

		return responseObj;

	}
}
