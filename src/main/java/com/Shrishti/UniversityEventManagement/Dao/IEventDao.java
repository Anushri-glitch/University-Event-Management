package com.Shrishti.UniversityEventManagement.Dao;

import com.Shrishti.UniversityEventManagement.Model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEventDao extends JpaRepository<Event,Integer> {

    @Query(value = "select * from event_tbl order by date", nativeQuery = true)
    public List<Event> getAllEventByDate();
}
