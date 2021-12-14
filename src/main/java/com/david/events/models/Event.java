package com.david.events.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="events")
public class Event {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotEmpty(message="Name is required!")
    @Size(min=3, max=30, message="Name must be between 3 and 30 characters")
    private String name;

	@NotNull(message="Date is required!")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	
	@NotEmpty
	@Size(min=3, max=30, message="Location must be between 3 and 30 characters")
    private String location;
    
    @NotEmpty(message="State is required!")
    private String state;
    
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    //Setting up the relationship to the users table
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    		name = "users_events",
    		joinColumns = @JoinColumn(name = "event_id"),
    		inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;
    
    //Setting up relationship with events and messages
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    		name = "messages",
    		joinColumns = @JoinColumn(name = "event_id"),
    		inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<Message> messages;
    
    //Set Relationship for one host 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="host_id")
    private User host;
    
	public Event() {
	}

	public Event(Long id,
			@NotEmpty(message = "Name is required!") @Size(min = 3, max = 30, message = "Name must be between 3 and 30 characters") String name,
			@NotEmpty(message = "Date is required!") Date date,
			@NotEmpty @Size(min = 3, max = 30, message = "Location must be between 3 and 30 characters") String location,
			@NotEmpty(message = "State is required!") String state, Date createdAt, Date updatedAt, List<User> users,
			List<Message> messages, User host) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.location = location;
		this.state = state;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.users = users;
		this.messages = messages;
		this.host = host;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
    
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public User getHost() {
		return host;
	}

	public void setHost(User host) {
		this.host = host;
	}

	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
}












