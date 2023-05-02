package com.Shrishti.UniversityEventManagement.Dao;

import com.Shrishti.UniversityEventManagement.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentDao extends JpaRepository <Student,Integer> {
}
