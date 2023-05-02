package com.Shrishti.UniversityEventManagement.Controller;

import com.Shrishti.UniversityEventManagement.Model.Event;
import com.Shrishti.UniversityEventManagement.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {

    @Autowired
    EventService eventService;

    @PostMapping(value = "/eventA")
    public String addEvent(@RequestBody Event event){
        return eventService.addEvent(event);
    }

    @GetMapping(value = "/eventSort")
    public List<Event> getAllEventByDate(){
        return eventService.getAllEventByDate();
    }

    @PutMapping(value = "/eventP/eventId/{eventId}")
    public String updateEvent(@PathVariable int eventId, @RequestBody Event event){
        return eventService.updateEvent(eventId, event);
    }

    @DeleteMapping(value = "/eventD/eventId/{eventId}")
    public String deleteEvent(@PathVariable int eventId){
        return eventService.deleteEvent(eventId);
    }
}
