package com.khaled.chatbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khaled.chatbot.model.Intent;
 
public interface IntentRepository  extends JpaRepository<Intent, Long> {

}
