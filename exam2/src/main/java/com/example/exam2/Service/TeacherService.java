package com.example.exam2.Service;

import com.example.exam2.Model.myStudent;
import com.example.exam2.Model.myTeacher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {


    ArrayList<myTeacher> teachers = new ArrayList<>();

    public ArrayList<myTeacher> getTeacher() {
        return teachers;
    }


    public boolean addTeacher(myTeacher myTeacher) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == myTeacher.getId()) {
                return false;

            }
        }
        teachers.add(myTeacher);
        return true; //Student added

    }

    public boolean updateTeacher(myTeacher myTeacher, int id) {

        for (int i = 0; i < teachers.size(); i++) {

            if (teachers.get(i).getId() == id) {
                teachers.set(i, myTeacher);
                return true;

            }

        }
        return false;//not updated


    }

    public boolean deleteTeacher(int id) {

        for (int i = 0; i < teachers.size(); i++) {

            if (teachers.get(i).getId() == id) {
                teachers.remove(i);
                return true;

            }

        }
        return false;//not deleted

    }
    public String getOneTeacher(int id ){
        for (int i = 0; i < teachers.size(); i++){
            if (teachers.get(i).getId()==id){

                return teachers.get(i).toString();
            }



        }return "teacher not in the system";


    }
}
