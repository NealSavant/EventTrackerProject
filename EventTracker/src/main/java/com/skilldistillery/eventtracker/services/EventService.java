package com.skilldistillery.eventtracker.services;

import java.util.List;

import com.skilldistillery.eventtracker.entities.Event;

public interface EventService {

	List<Event> searchEventByDate(String date);
	Event searchEventByName(String name);
	Event create(Event event);
	boolean delete(Integer id);
	Event update(Integer id);
	
	
}
