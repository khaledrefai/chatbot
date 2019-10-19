package com.khaled.chatbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khaled.chatbot.model.SaptcoTrips;

public interface TripRepository  extends JpaRepository<SaptcoTrips, Long> {

}
