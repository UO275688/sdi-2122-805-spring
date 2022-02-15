package com.uniovi.sdi2122805labspring.controllers;

import com.uniovi.sdi2122805labspring.entities.Teacher;
import com.uniovi.sdi2122805labspring.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/teacher/list")
    public String getList(Model model) {
        model.addAttribute("teacherList", teacherService.getTeachers());
        return "mark/list";
    }

    @RequestMapping(value = "/teacher/add", method = RequestMethod.POST)
    public String add(@ModelAttribute Teacher teacher) {
        teacherService.addTeacher(teacher);
        return "Teacher with id " + teacher.getId() + " added";
    }

    @RequestMapping("/mark/details/{id}")
    public String getDetail(Model model, @PathVariable Long id) {
        model.addAttribute("teacher", teacherService.getTeacher(id));
        return "Ok";
    }

    @RequestMapping("/teacher/delete/{id}")
    public String deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
        return "Teacher with id " + id + " deleted";
    }

    //como el getdetail?
    @RequestMapping(value = "/teacher/edit/{id}")
    public String getEdit(Model model, @PathVariable Long id) {
        model.addAttribute("teacher", teacherService.getTeacher(id));
        return "OK";
    }

    @RequestMapping(value = "/teacher/edit/{id}", method = RequestMethod.POST)
    public String setEdit(@ModelAttribute Teacher teacher, @PathVariable Long id) {
        teacher.setId(id);
        teacherService.addTeacher(teacher);
        return "Teacher with id " + id + " edited";
    }
}
