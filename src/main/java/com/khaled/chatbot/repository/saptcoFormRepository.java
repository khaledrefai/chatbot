package com.khaled.chatbot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.khaled.chatbot.model.Conversation;
import com.khaled.chatbot.model.SaptcoForm;;

public interface saptcoFormRepository  extends JpaRepository<SaptcoForm, Long> {
	
List<SaptcoForm> findByConversation(Conversation conv);
}
