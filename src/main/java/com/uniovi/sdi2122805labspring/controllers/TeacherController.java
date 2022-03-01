package com.uniovi.sdi2122805labspring.controllers;

import com.uniovi.sdi2122805labspring.entities.Mark;
import com.uniovi.sdi2122805labspring.entities.Teacher;
import com.uniovi.sdi2122805labspring.entities.User;
import com.uniovi.sdi2122805labspring.services.TeacherService;
import com.uniovi.sdi2122805labspring.validators.TeacherValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private TeacherValidator teacherValidator;

    @RequestMapping("/teacher/list")
    public String getList(Model model) {
        model.addAttribute("teacherList", teacherService.getTeachers());
        return "teacher/list";
    }

    @RequestMapping(value = "/teacher/add", method = RequestMethod.POST)
    public String add(@Validated Teacher teacher, BindingResult result) {
        teacherValidator.validate(teacher, result);
        if(result.hasErrors()){
            return "/teacher/add";
        }

        teacherService.addTeacher(teacher);
        return "redirect:/teacher/list";
    }

    @RequestMapping("/teacher/details/{id}")
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
    public String setEdit(@ModelAttribute Teacher teacher, @PathVariable String id) {
        teacher.setId(id);
        teacherService.addTeacher(teacher);
        return "Teacher with id " + id + " edited";
    }

    @RequestMapping("/teacher/list/update")
    public String updateList(Model model) {
        model.addAttribute("teacherList", teacherService.getTeachers());
        return "teacher/list :: tableTeachers";
    }
}
