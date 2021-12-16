package com.david.events.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.david.events.models.Event;
import com.david.events.models.LoginUser;
import com.david.events.models.Message;
import com.david.events.models.User;
import com.david.events.services.EventService;
import com.david.events.services.UserService;

@Controller
public class HomeController {

	@Autowired
    private UserService userServ;
	@Autowired
	private EventService eventServ;
    
	//route to the main login/register page
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    
    //handle register user
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        userServ.register(newUser, result);
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        session.setAttribute("user_id", newUser.getId());
        return "redirect:/events";
    }
    
    //handle login user
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        User user = userServ.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        session.setAttribute("user_id", user.getId());
        return "redirect:/events";
    }
    
    // logout
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // invalidate session
        // redirect to login page
    		session.invalidate();
    		return "redirect:/";
    }
    
    //Welcome page with all events
    @GetMapping("/events")
    public String events(Model model, HttpSession session, RedirectAttributes redirectAtt) {
    	//checks to see if user is in session
    	if(session.getAttribute("user_id") != null) {
    		//gets the local events
	    	List<Event> localEvents = eventServ.localEvents(userServ.getState((Long) session.getAttribute("user_id")));
	    	model.addAttribute("localEvents", localEvents);
	    	//gets the non-local events
	    	List<Event> notLocal = eventServ.notLocalEvents(userServ.getState((Long) session.getAttribute("user_id")));
	    	model.addAttribute("notLocal", notLocal);
	    	//gets the user from session
	    	model.addAttribute("user", userServ.findUser((Long) session.getAttribute("user_id")));
	    	//gets an empty event
	    	model.addAttribute("newEvent", new Event());
	    	return "events/welcome.jsp";
    	} else {
    		redirectAtt.addFlashAttribute("error", "You must login first");
    		return "redirect:/";
    	}
    	
    }
    
    //handle create new event
    @PostMapping("/events/new")
    public String createEvent(@Valid @ModelAttribute("newEvent") Event event, BindingResult result, Model model, HttpSession session) {
    		if(result.hasErrors()) {
    			return "events/welcome.jsp";
    		} else {
    			eventServ.createEvent(event);
    			return "redirect:/events";
    		}
    }
    
    //join event
    @GetMapping("/join/{id}")
    public String joinEvent(@PathVariable("id") Long eventId, HttpSession session) {
    		eventServ.add(eventId, (Long) session.getAttribute("user_id"));
    		return "redirect:/events";
    }
    
    //leave event
    @GetMapping("/cancel/{id}")
    public String leaveEvent(@PathVariable("id") Long eventId, HttpSession session) {
    		eventServ.leave(eventId, (Long) session.getAttribute("user_id"));
    		return "redirect:/events";
    }
    
    //edit event form
    @GetMapping("/events/{id}/edit")
    public String editEvent(@PathVariable("id") Long id, Model model, HttpSession session) {
    		Event event = eventServ.findEvent(id);
    		if (userServ.findUser((Long) session.getAttribute("user_id")) == event.getHost()) {
    			model.addAttribute("event", event);
    			return "events/edit.jsp";
    		} else {
    			return "redirect:/events";
    		}
    }
    
    //edit event handler
    @PutMapping("/events/{id}/edit")
    public String updateEvent(@Valid @ModelAttribute("event") Event e, BindingResult result, Model model) {
    		if(result.hasErrors()) {
			return "events/edit.jsp";
		} else {
			eventServ.updateEvent(e);
			return "redirect:/events";
		}
    }
    
    //delete event handler
    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable("id") Long id) {
    		eventServ.delete(id);
    		return "redirect:/events";
    }
    
    //one event page
    @GetMapping("/events/{id}")
    public String showEvent(@PathVariable("id") Long id, Model model, HttpSession session) {
    		if (session.getAttribute("user_id") != null) {
    			//gets the data for the specific event then inserts the data into a model attribute
    			Event event = eventServ.findEvent(id);
    			model.addAttribute("event", event);
    			session.setAttribute("eventId", event.getId());
    			//gets the data for the number of users then inserts the data into a model attribute
    			Integer numUsers = eventServ.numOfUsers(id);
    			model.addAttribute("numUsers", numUsers);
    			//attribute that has a new instance of message ready to go
    			model.addAttribute("newMessage", new Message());
    			//gets the user from session
    	    	model.addAttribute("user", userServ.findUser((Long) session.getAttribute("user_id")));
    			return "events/showone.jsp";
    		} else {
    			return "redirect:/";
    		}
    }
    
    //create new message
    @PostMapping("/events/messages/new")
    public String createMessage(@Valid @ModelAttribute("newMessage") Message message, BindingResult result, Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
    		if(result.hasErrors()) {
    			System.out.println("I am in the controller with errors");
    			return "redirect/events/{}";
    		} else {
    			eventServ.createMessage(message);
    			System.out.println("I am in the controller");
    			return "redirect:/events";
    		}
    }
}












