package com.driver;
import java.util.*;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    HashMap<String,Student> studentDb=new HashMap<>();
    HashMap<String,Teacher> teacherDb=new HashMap<>();
    HashMap<String,String> studentTeacherPair=new HashMap<>();
    public void addStudent(Student student){
        String key= student.getName();
        studentDb.put(key,student);
        return;
    }
    public void addTeacher(Teacher teacher){
        String key= teacher.getName();
        teacherDb.put(key,teacher);
        return;
    }
    public void addStudentTeacherPair(String student, String teacher){
        studentTeacherPair.put(student,teacher);
        return;
    }
    public Student getStudentByName(String studentName){
        Student student=studentDb.get(studentName);
        return student;
    }
    public Teacher getTeacherByName(String teacherName){
        Teacher teacher=teacherDb.get(teacherName);
        return teacher;
    }
    public List<String> getStudentsByTeacherName(String teacherName){
        List<String> students=new ArrayList<>();
        for(String s:studentTeacherPair.keySet()){
            if(studentTeacherPair.get(s).equals(teacherName))
                students.add(s);
        }
        return students;
    }
    public List<String> getAllStudents(){
        List<String> students=new ArrayList<>();
        for(String s:studentDb.keySet())
            students.add(s);
        return students;
    }
    public void deleteTeacherByName(String teacherName){
        teacherDb.remove(teacherName);
        for(String s:studentTeacherPair.keySet()){
            if(studentTeacherPair.get(s).equals(teacherName)){
                studentDb.remove(s);
                studentTeacherPair.remove(s);
            }
        }
        return;
    }
    public void deleteAllTeachers(){
        for(String t:teacherDb.keySet()){
            teacherDb.remove(t);
            for(String s:studentTeacherPair.keySet()){
                if(studentTeacherPair.get(s).equals(t)){
                    studentDb.remove(s);
                    studentTeacherPair.remove(s);
                }
            }
        }
        return;
    }
}
