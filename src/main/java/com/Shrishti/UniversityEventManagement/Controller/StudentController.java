package com.Shrishti.UniversityEventManagement.Controller;

import com.Shrishti.UniversityEventManagement.Model.Student;
import com.Shrishti.UniversityEventManagement.Service.StudentService;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping(value = "/api/studentI/{studentId}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable int studentId){
        return studentService.getStudentById(studentId);
    }

    @PutMapping(value = "/studentU/{studentId}")
    public String updateStudent(@PathVariable int studentId, @RequestBody Student student){
        return studentService.updateStudent(studentId, student);
    }

    @DeleteMapping(value =  "/studentD/{studentId}")
    public String deleteStudent(@PathVariable int studentId){
        return studentService.deleteStudent(studentId);
    }

    @PatchMapping(value = "/studentDepartment/{studentId}")
    public ResponseEntity<Student> updateStudentDepartment(@PathVariable int studentId, @RequestBody Student student){
        return studentService.updateStudentDepartment(studentId,student);
    }
}
