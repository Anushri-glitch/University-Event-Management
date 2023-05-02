package com.Shrishti.UniversityEventManagement.Service;

import com.Shrishti.UniversityEventManagement.Dao.IEventDao;
import com.Shrishti.UniversityEventManagement.Model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class EventService {

    @Autowired
    IEventDao eventDao;

    public String addEvent(Event event) {
        eventDao.save(event);
        return "Event Added Successfully";
    }


    public List<Event> getAllEventByDate() {
        List<Event> eventList = eventDao.getAllEventByDate();
        return eventList;
    }

    public String updateEvent(int eventId, Event event) {
        Event oldEvent = eventDao.findById(eventId).get();
        if(oldEvent != null){
            oldEvent.setEventName(event.getEventName());
            oldEvent.setLocationOfEvent(event.getLocationOfEvent());
            oldEvent.setDate(event.getDate());
            oldEvent.setStartTime(event.getStartTime());
            oldEvent.setEndTime(event.getEndTime());
            eventDao.save(oldEvent);
            return oldEvent.toString();
        }
        return "Event Not Updated!!!";
    }


    public String deleteEvent(int eventId) {
        Event event = eventDao.findById(eventId).get();
        if(event != null){
            eventDao.delete(event);
            return "Event Deleted!!!";
        }
        return "Event not exist!!!";
    }
}
