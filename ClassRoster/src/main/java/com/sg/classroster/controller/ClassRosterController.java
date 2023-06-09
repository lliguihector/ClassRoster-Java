/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.controller;

import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dao.ClassRosterDaoException;
import com.sg.classroster.dao.ClassRosterDaoFileImpl;
import com.sg.classroster.dto.Student;
import com.sg.classroster.ui.ClassRosterView;
import com.sg.classroster.ui.UserIO;
import com.sg.classroster.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author hectorlliguichuzca
 */
public class ClassRosterController 
{
    //Removed in order to perform dependency injection.
//    ClassRosterDao dao = new ClassRosterDaoFileImpl();
//      ClassRosterView view = new ClassRosterView();

    ClassRosterView view;
    ClassRosterDao dao; 
    public ClassRosterController(ClassRosterDao dao, ClassRosterView view){
        this.dao = dao;
        this.view = view; 
    }
    
    
	    public void run() {
	        boolean keepGoing = true;
	        int menuSelection = 0;
                
                try{
	        while (keepGoing) {
     
              menuSelection = getMenueSelection();
	       
	            
	            switch (menuSelection) {
	                case 1:
                            listStudents();
	                    break;
	                case 2:
                            createStudent();
	                    break;
	                case 3:
	                    viewStudent();
	                    break;
	                case 4:
	                    removeStudent();
	                    break;
	                case 5:
	                    keepGoing = false;
	                    break;
	                default:
	                    unknownCommand();
	            }

	        }
	           exitMessage();
	    }catch(ClassRosterDaoException e){
                view.displayErrorMessage(e.getMessage());
            }
            }
            
            
            //PRIVATE METHODS 
            
            private int getMenueSelection(){
                return view.printMenuAndGetSelection();
            }
            
            private void createStudent()throws ClassRosterDaoException{
                view.displayCreateBanner();
                Student newStudent = view.getNewStudentInfo();
                dao.addStudent(newStudent.getStudentId(), newStudent);
                view.displayCreateSuccessBanner();  
            }
            
            private void listStudents() throws ClassRosterDaoException{
                view.displayDisplayAllBanner();
                List<Student> studentList = dao.getAllStudents();
                view.displayStudentList(dao.getAllStudents());
            }
            
            private void viewStudent()throws ClassRosterDaoException{
                view.displayDisplayStudentBanner();
                String studentId = view.getStudentIdChoice();
                Student student = dao.getStudent(studentId);
                view.displayStudent(student);   
            }
            
         
            private void removeStudent()throws ClassRosterDaoException{
                view.displayRemoveStudentBanner();
                String studentId = view.getStudentIdChoice();
                Student removeStudent = dao.removeStudent(studentId);
                view.displayRemoveSuccessBanner();
                
            }
            
            
    private void unknownCommand() {
    view.displayUnknownCommandBanner();
}

    private void exitMessage() {
    view.displayExitBanner();
}
            
}
