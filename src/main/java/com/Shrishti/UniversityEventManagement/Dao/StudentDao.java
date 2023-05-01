package com.Shrishti.UniversityEventManagement.Dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDao {

    private String studentId;
    private String firstName;
    private String lastName;
    private String age;
    private String department;
}
