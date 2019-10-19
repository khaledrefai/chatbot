package com.khaled.chatbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.khaled.chatbot.model.Languages;
import com.khaled.chatbot.model.Messegs;
import com.khaled.chatbot.model.MsgId;

import java.util.List;

public interface MessegesRepository extends JpaRepository<Messegs, MsgId> {

	//List<Messegs> findByIdAndLanguage(long id , Languages lang);
}
