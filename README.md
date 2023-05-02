# University-Event-Management
##### :purple_square: Its a API Based Web Application
## :one: Frameworks and Languages Used -
    1. SpringBoot
    2. JAVA
    3. Postman
    4. SQL
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
## :two: Dataflow (Functions Used In)
### :purple_square: 1. Model - Model is used to Iniitialize the required attributes and create the accessable constructors and methods
#### :o: Student.java
```java
package com.Shrishti.UniversityEventManagement.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int studentId;
    private String firstName;
    private String lastName;
    private String age;
    private String department;
}
```

#### :o: Event.java
```java
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
```
##### To See Model
:white_check_mark: [UniversityEvent-Model](https://github.com/Anushri-glitch/University-Event-Management/tree/master/src/main/java/com/Shrishti/UniversityEventManagement/Model)
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

### :purple_square: 2. Service - This Layer is used to write the logic of our CRUD operaions.
#### :o: StudentService.java
```java
@Service
public class StudentService {

    @Autowired
    IStudentDao studentDao;

    public String addStudent(Student student) {
        studentDao.save(student);
        return "Student Saved Successfully";
    }

    public List<Student> getAllStudent() {
        return studentDao.findAll();
    }

    public Student getStudentById(int studentId) {
        Student student = studentDao.findById(studentId).get();
        return student;
    }

    public ResponseEntity<Student> updateStudentDepartment(int studentId, Student newStudent) {
        Student oldStudent = getStudentById(studentId);
        oldStudent.setDepartment(newStudent.getDepartment());

        final Student updateStudent = studentDao.save(oldStudent);
        return ResponseEntity.ok(updateStudent);
    }
}
```

#### :o: EventService.java
```java
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
}
```

#### To See Service
:white_check_mark: [UniversityEvent-Service](https://github.com/Anushri-glitch/University-Event-Management/tree/master/src/main/java/com/Shrishti/UniversityEventManagement/Service)
----------------------------------------------------------------------------------------------------------------------------------------------------

### :purple_square: 3. Controller - This Controller is used to like UI between Model and Service and also for CRUD Mappings.
#### :o: StudentController.java
```java
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping(value = "/studentA")
    public String addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping(value = "/studentGA")
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }
}
```

#### :o: EventController.java
```java
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
}
```

#### To See Controller
:white_check_mark: [UniversityEvent-Controller](https://github.com/Anushri-glitch/University-Event-Management/tree/master/src/main/java/com/Shrishti/UniversityEventManagement/Controller)
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
### :purple_square: 3. Repository : data access object (DAO) is an object that provides an abstract interface to some type of database or other persistence mechanisms.
#### :o: IStudentDao.java
```java
package com.Shrishti.UniversityEventManagement.Dao;

import com.Shrishti.UniversityEventManagement.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentDao extends JpaRepository <Student,Integer> {
}
```

#### :o: IEventDao.java
```java
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
```
#### To See Repository
:white_check_mark: [UniversityEvent-DAO](https://github.com/Anushri-glitch/University-Event-Management/tree/master/src/main/java/com/Shrishti/UniversityEventManagement/Dao)
-------------------------------------------------------------------------------------------------------------------------------------------------------
## :three: DataStructures Used in Project
    1. ArrayList
    2. ResponseEntity
    3. List
-------------------------------------------------------------------------------------------------------------------------------------------------------
## :four: DataBase Response In project

:arrow_right: ![Screenshot (775)](https://user-images.githubusercontent.com/47708011/235756567-af3bf648-f159-44b3-a7ea-06a95173115c.png)


:arrow_right: ![Screenshot (777)](https://user-images.githubusercontent.com/47708011/235757702-d6b27415-6975-4f55-b4fc-df9fde376844.png)

----------------------------------------------------------------------------------------------------------------------------------------------------------
## :five: Project Summary
### :o: Project result 
#### :purple_square: SAVE STUDENT : http://localhost:8080/studentA
![Screenshot (768)](https://user-images.githubusercontent.com/47708011/235758202-fc9af7e2-6c02-43e5-a658-d45427baaa2d.png)

#### :purple_square: FIND All STUDENT : http://localhost:8080/studentGA
![Screenshot (769)](https://user-images.githubusercontent.com/47708011/235758648-44bc74a9-ef6d-4e95-aa87-227ffd6f8c11.png)

#### :purple_square: FIND STUDENT BY ID : http://localhost:8080/api/studentI/{studentId}
![Screenshot (770)](https://user-images.githubusercontent.com/47708011/235759128-70fa89d0-64e3-494c-8c01-6c1b92e9adbe.png)

#### :purple_square: UPDATE STUDENT : http://localhost:8080/studentU/{studentId}
![Screenshot (772)](https://user-images.githubusercontent.com/47708011/235759717-75823041-1bde-40a1-88b9-e3a689f1080c.png)

#### :purple_square: UPDATE STUDENT DEPARTMENT : http://localhost:8080/studentDepartment/{studentId}
![Screenshot (774)](https://user-images.githubusercontent.com/47708011/235760166-51dc077c-20dd-47af-96e6-b5024c1db0ed.png)

#### :purple_square: DELETE STUDENT : http://localhost:8080/studentD/{studentId}
![Screenshot (773)](https://user-images.githubusercontent.com/47708011/235760567-a6cfb0b4-6360-4fc2-aea9-9f4c0cdf54b5.png)

#### :purple_square: SAVE EVENT : http://localhost:8080/eventA
![Screenshot (776)](https://user-images.githubusercontent.com/47708011/235760896-99041c5e-e17f-425a-ad17-39cd14f0cc41.png)

#### :purple_square: FIND ALL SORTED EVENTS BY DATE : http://localhost:8080/eventSort
![Screenshot (778)](https://user-images.githubusercontent.com/47708011/235761283-9e710bd2-a8c0-45a4-aa24-090372f11e68.png)

#### :purple_square: UPDATE EVENT : http://localhost:8080/eventP/eventId/{eventId}
![Screenshot (779)](https://user-images.githubusercontent.com/47708011/235761656-4592ee87-ca14-4acc-bbc1-28ba2aff2ea5.png)

#### :purple_square: SAVE EVENT : http://localhost:8080/eventD/eventId/{eventId}
![Screenshot (781)](https://user-images.githubusercontent.com/47708011/235762056-d3361eee-b747-426a-9c6d-665084ecbb16.png)
----------------------------------------------------------------------------------------------------------------------------------------------------------
