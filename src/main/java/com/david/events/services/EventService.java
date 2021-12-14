package com.david.events.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.david.events.models.Event;
import com.david.events.models.User;
import com.david.events.repositories.EventRepository;

@Service
public class EventService {

	private final EventRepository eventRepo;
	private final UserService userServ;
	
	public EventService(EventRepository eventRepo, UserService userServ) {
		this.eventRepo = eventRepo;
		this.userServ = userServ;
	}
	
	//gets all events in a user's state
	public List<Event> localEvents(String search){
		return (List<Event>) eventRepo.findByStateContaining(search);
	}
	
	//gets all events not in user's state
	public List<Event> notLocalEvents(String search){
		return (List<Event>) eventRepo.findByStateNotContaining(search);
	}
	
	//create an event
	public Event createEvent(Event event) {
		return eventRepo.save(event);
	}
	
	//get one event
	public Event findEvent(Long id) {
		Optional<Event> event = eventRepo.findById(id);
		if(event.isPresent()) {
			return event.get();
		} else {
			return null;
		}
	}
	
	//updates event
	public Event updateEvent(Event event) {
		return eventRepo.save(event);
	}
	
	
	//adds a user to an event
	public Event add(Long eventId, Long userId) {
		
		Event thisEvent = findEvent(eventId);
		
		User thisUser = userServ.findUser(userId);
		
		thisEvent.getUsers().add(thisUser);
		
		return eventRepo.save(thisEvent);
	}
	
	//deletes a user from an event
	public Event leave(Long eventId, Long userId) {
		
		Event thisEvent = findEvent(eventId);
		
		User thisUser = userServ.findUser(userId);
		
		thisEvent.getUsers().remove(thisUser);
		
		return eventRepo.save(thisEvent);
	}
	
	// deletes an event
	public void delete(Long id) {
		eventRepo.deleteById(id);
	}
	
	//counts the num of users
	public Integer numOfUsers(Long id) {
		Event thisEvent = findEvent(id);
		
		return thisEvent.getUsers().size();
	}
}









