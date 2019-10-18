package com.khaled.chatbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khaled.chatbot.model.City;

public interface CityRepository extends JpaRepository<City, Long>  {

}
