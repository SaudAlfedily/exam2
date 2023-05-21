package com.example.exam2.Service;

import com.example.exam2.Model.myStudent;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@Service
public class StudentService {

    ArrayList<myStudent> students=new ArrayList<>();

    public ArrayList<myStudent> getStudent() {
        return students;
    }


    public boolean addStudent(myStudent myStudent){
        for (int i=0;i<students.size();i++) {
            if (students.get(i).getId() == myStudent.getId()) {
                return false;

            }
        } students.add(myStudent);
        return true; //Student added

    }

    public boolean updateStudent( myStudent myStudent, int id){

        for (int i=0;i<students.size();i++){

            if(students.get(i).getId()==id){
                students.set(i,myStudent);
                return true;

            }

        }return false;//not updated


    }
    public boolean deleteStudent(  int id){

        for (int i=0;i<students.size();i++){

            if(students.get(i).getId()==id){
                students.remove(i);
                return true;

            }

        }return false;//not deleted


    }

    // i take the name form the body in this method as a text form not json
    public String getOneStudent(String name ){
        for (int i = 0; i < students.size(); i++){
            if (students.get(i).getName().equalsIgnoreCase(name)){

                return students.get(i).toString();
            }



        }return "Students not in the system";


    }

}
