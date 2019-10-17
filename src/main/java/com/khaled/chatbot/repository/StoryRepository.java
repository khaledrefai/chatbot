package com.khaled.chatbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khaled.chatbot.model.Stories;

public interface StoryRepository extends JpaRepository<Stories, Long> {

}
