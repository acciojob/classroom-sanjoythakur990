package com.driver;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public void addStudent(Student student){
        studentRepository.addStudent(student);
        return;
    }
    public void addTeacher(Teacher teacher){
        studentRepository.addTeacher(teacher);
        return;
    }
    public void addStudentTeacherPair(String student, String teacher){
        studentRepository.addStudentTeacherPair(student,teacher);
        return;
    }
    public Student getStudentByName(String studentName){
        Student student=studentRepository.getStudentByName(studentName);
        return student;
    }
    public Teacher getTeacherByName(String teacherName){
        Teacher teacher=studentRepository.getTeacherByName(teacherName);
        return teacher;
    }
    public List<String> getStudentsByTeacherName(String teacherName){
        List<String> students=studentRepository.getStudentsByTeacherName(teacherName);
        return students;
    }
    public List<String> getAllStudents(){
        List<String> students=studentRepository.getAllStudents();
        return students;
    }
    public void deleteTeacherByName(String teacherName){
        studentRepository.deleteTeacherByName(teacherName);
        return;
    }
    public void deleteAllTeachers(){
        studentRepository.deleteAllTeachers();
        return;
    }
}
