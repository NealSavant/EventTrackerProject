package com.skilldistillery.eventtracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.eventtracker.entities.Event;
import com.skilldistillery.eventtracker.repositories.EventRepository;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository repo;

	@Override
	public Event searchEventByDate(String date) {
		return repo.findByDate(date);
	}

	@Override
	public Event searchEventByName(String name) {
		name = "%" + name + "%";
		return repo.findByNameLike(name);
	}

	@Override
	public Event create(Event event) {
		repo.saveAndFlush(event);
		return event;
	}

	@Override
	public boolean delete(Integer id) {
		Optional<Event> opEvent = repo.findById(id);
		if (opEvent.isPresent()) {
			Event toDelete = opEvent.get();
			repo.delete(toDelete);
			return true;
		}
		return false;
	}

	@Override
	public Event update(Integer id, Event event) {
		Optional<Event> opEvent = repo.findById(id);
		if (opEvent.isPresent()) {
			Event toReplace = opEvent.get();
			int newId = toReplace.getId();
			event.setId(newId);
			return repo.saveAndFlush(event);
		}
		System.err.println("***Did not update");
		return null;
	}

	@Override
	public List<Event> listEvents() {
		return repo.findAll();
	}

}
