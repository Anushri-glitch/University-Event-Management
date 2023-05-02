package com.Shrishti.UniversityEventManagement.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "event_tbl")
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int eventId;
    private String eventName;
    private String locationOfEvent;
    private String date;
    private Timestamp startTime;
    private Timestamp endTime;
}
