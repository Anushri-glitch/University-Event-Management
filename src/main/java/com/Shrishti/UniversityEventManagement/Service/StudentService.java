package com.Shrishti.UniversityEventManagement.Service;

import com.Shrishti.UniversityEventManagement.Dao.IStudentDao;
import com.Shrishti.UniversityEventManagement.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

//        for(Student student : studentList){
//            if(student.getStudentId() == studentId){
//                return student;
//            }
//        }
//        return null;
    }


    public String updateStudent(int studentId, Student student) {
        Student oldStudent = studentDao.findById(studentId).get();
        oldStudent.setFirstName(student.getFirstName());
        oldStudent.setLastName(student.getLastName());
        oldStudent.setAge(student.getAge());
        oldStudent.setDepartment(student.getDepartment());
        studentDao.save(oldStudent);
        return oldStudent.toString();
    }

    public String deleteStudent(int studentId) {
        Student student = studentDao.findById(studentId).get();
        studentDao.delete(student);
        return "student deleted";
    }

    public ResponseEntity<Student> updateStudentDepartment(int studentId, Student newStudent) {
        Student oldStudent = getStudentById(studentId);
        oldStudent.setDepartment(newStudent.getDepartment());

        final Student updateStudent = studentDao.save(oldStudent);
        return ResponseEntity.ok(updateStudent);
    }
}
