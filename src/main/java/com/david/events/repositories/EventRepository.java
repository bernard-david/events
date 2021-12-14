package com.david.events.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.david.events.models.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long>{
	
	//finds events that are in the user's state
	List<Event> findByStateContaining(String search);
	
	List<Event> findByStateNotContaining(String search);
}
