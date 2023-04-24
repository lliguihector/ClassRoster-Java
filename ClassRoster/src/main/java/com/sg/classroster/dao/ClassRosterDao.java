/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.dao;

import com.sg.classroster.dto.Student;
import java.util.List;

/**
 *
 * @author hectorlliguichuzca
 */
public interface ClassRosterDao {
    
    
    //CREATE
    Student addStudent(String studentID, Student student)
    throws ClassRosterDaoException;
    //Read
    List<Student> getAllStudents()
    throws ClassRosterDaoException;
    //Read By Id
    Student getStudent(String studentId)
    throws ClassRosterDaoException;
    //Update 

    //Delete 
    Student removeStudent(String studentId)
    throws ClassRosterDaoException;

}
