package com.uniovi.sdi2122805labspring.services;

import com.uniovi.sdi2122805labspring.entities.Teacher;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;

@Service
public class TeacherService {

    private List<Teacher> teacherList = new LinkedList<>();

    @PostConstruct
    public void init() {
        teacherList.add(new Teacher(1L, "Mikel", "Fernandez", "alumno"));
        teacherList.add(new Teacher(2L, "Matteo", "Tobish", "alumno"));
    }

    public List<Teacher> getTeachers() {
        return teacherList;
    }

    public Teacher getTeacher(Long id) {
        return teacherList.stream().filter(teacher -> teacher.getId().equals(id)).findFirst().get();
    }

    public void addTeacher(Teacher teacher) {
        if(teacher.getId() == null)
            teacher.setId(teacherList.get(teacherList.size() - 1).getId() + 1);
        teacherList.add(teacher);
    }

    public void deleteTeacher(Long id) {
        teacherList.removeIf(teacher -> teacher.getId().equals(id));
    }
}
