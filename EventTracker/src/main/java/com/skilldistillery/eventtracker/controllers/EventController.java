package com.skilldistillery.eventtracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.eventtracker.entities.Event;
import com.skilldistillery.eventtracker.services.EventService;

@RestController
@RequestMapping("api")
public class EventController {

	@Autowired
	EventService svc;

	@GetMapping("events")
	public List<Event> listEvents() {
		return svc.listEvents();
	}

	@GetMapping("events/{date}")
	public Event searchByDate(@PathVariable(value = "date") String date) {
		return svc.searchEventByDate(date);
	}

	@GetMapping("events/{name}")
	public Event searchByName(@PathVariable(value = "name") String name) {
		return svc.searchEventByName(name);
	}

//	@PostMapping("events")
//	public Event create(@RequestBody Event event) {
//		System.out.println("returned event" + event);
//		return svc.create(event);
//	}
	
	//recieveing from another controller
//	@PostMapping("events")
//	public void testEvent(@RequestParam String name) {
//		System.out.println(name);
//	}
	
	class shit{
		public String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public shit(String name) {
			super();
			this.name = name;
		}
		
	}
	@PostMapping("events")
	public shit testEvent(@RequestBody String body) {
		shit moreShit = new shit(body);
		System.out.println(body);
		return moreShit;
	}

	@DeleteMapping("events/{id}")
	public boolean delete(@PathVariable Integer id) {
		return svc.delete(id);
	}
	
	@PutMapping("events/{id}")
	public Event update(@PathVariable Integer id, @RequestBody Event event) {
		return svc.update(id, event);
	}
}
