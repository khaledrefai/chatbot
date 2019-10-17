package com.khaled.chatbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khaled.chatbot.model.Nlu;

public interface NluRepository  extends JpaRepository<Nlu, Long> {

}
