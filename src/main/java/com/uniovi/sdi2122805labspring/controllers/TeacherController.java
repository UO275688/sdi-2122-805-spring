package com.uniovi.sdi2122805labspring.controllers;

import com.uniovi.sdi2122805labspring.entities.Teacher;
import com.uniovi.sdi2122805labspring.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/teacher/list")
    public String getList() {
        return teacherService.getTeachers().toString();
    }

    @RequestMapping(value = "/teacher/add", method = RequestMethod.POST)
    public String add(@ModelAttribute Teacher teacher) {
        teacherService.addTeacher(teacher);
        return "Teacher with id " + teacher.getId() + " added";
    }

    @RequestMapping("/teacher/details/{id}")
    public String getDetail(@PathVariable Long id) {
        return teacherService.getTeacher(id).toString();
    }

    @RequestMapping("/teacher/delete/{id}")
    public String deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
        return "Teacher with id " + id + " deleted";
    }

    //como el getdetail?
    @RequestMapping(value = "/teacher/edit/{id}")
    public String getEdit(@PathVariable Long id) {
        return teacherService.getTeacher(id).toString();
    }

    @RequestMapping(value = "/teacher/edit/{id}", method = RequestMethod.POST)
    public String setEdit(@ModelAttribute Teacher teacher, @PathVariable Long id) {
        teacher.setId(id);
        teacherService.addTeacher(teacher);
        return "Teacher with id " + id + " edited";
    }
}
