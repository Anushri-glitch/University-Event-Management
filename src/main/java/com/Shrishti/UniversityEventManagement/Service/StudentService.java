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
        List<Student> studentList = new ArrayList<>();
        studentList = studentDao.findAll();
        return studentList;
    }

    public Student getStudentById(String studentId) {
        List<Student> studentList = new ArrayList<>();
        studentList = studentDao.findAll();

        for(Student student : studentList){
            if(student.getStudentId().equalsIgnoreCase(studentId)){
                return student;
            }
        }
        return null;
    }


    public String updateStudent(String studentId, Student student) {
        List<Student> studentList = new ArrayList<>();
        studentList = studentDao.findAll();

        for(Student oldStudent : studentList){
            if(oldStudent.getStudentId().equalsIgnoreCase(studentId)){
                studentDao.delete(oldStudent);
                studentDao.save(student);
                return "Student Updated Successfully";
            }
            return "Student Data is not Updated!!!";
        }
        return "Student Id does not exist!!!";
    }

    public String deleteStudent(String studentId) {
        List<Student> studentList = new ArrayList<>();
        studentList = studentDao.findAll();

        for(Student student : studentList) {
            if (student.getStudentId().equalsIgnoreCase(studentId)) {
                studentDao.delete(student);
                return "Student Deleted Successfully";
            }
            return "Student Deletion Unsuccessful!!";
        }
        return "Student Id does not exist!!!";
    }

    public ResponseEntity<Student> updateStudentDepartment(String studentId, Student newStudent) {
        Student oldStudent = getStudentById(studentId);
        oldStudent.setDepartment(newStudent.getDepartment());

        final Student updateStudent = studentDao.save(oldStudent);
        return ResponseEntity.ok(updateStudent);
    }
}
