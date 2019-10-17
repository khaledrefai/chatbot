package com.khaled.chatbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khaled.chatbot.model.Actions;;

public interface ActionRepoditory   extends JpaRepository<Actions, Long>{

}
