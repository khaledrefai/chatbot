package com.khaled.chatbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.khaled.chatbot.model.Conversation;

 
public interface ConversationRepository extends CrudRepository<Conversation, Long>  {

}
