package com.skilldistillery.eventtracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.eventtracker.entities.Event;

public interface EventRepository extends JpaRepository<Event, Integer>{

	List<Event> findByDate(String date);
	Event findByNameLike(String name);
	
}
