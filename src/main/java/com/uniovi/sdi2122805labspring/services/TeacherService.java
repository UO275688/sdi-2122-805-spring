package com.uniovi.sdi2122805labspring.services;

import com.uniovi.sdi2122805labspring.entities.Mark;
import com.uniovi.sdi2122805labspring.entities.Teacher;
import com.uniovi.sdi2122805labspring.repositories.MarksRepository;
import com.uniovi.sdi2122805labspring.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getTeachers() {
        List<Teacher> teachers = new ArrayList<Teacher>();
        teacherRepository.findAll().forEach(teachers::add);
        return teachers;
    }

    public Teacher getTeacher(Long id) {
        return teacherRepository.findById(id).get();
    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }
}
