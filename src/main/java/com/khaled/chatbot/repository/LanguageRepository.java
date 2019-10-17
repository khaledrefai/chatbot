package com.khaled.chatbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khaled.chatbot.model.Languages;

public interface LanguageRepository extends JpaRepository<Languages, Long> {

}
