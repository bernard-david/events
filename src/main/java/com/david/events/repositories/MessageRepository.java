package com.david.events.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.david.events.models.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long>{

	
}
