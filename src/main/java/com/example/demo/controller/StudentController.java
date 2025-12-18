package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Stuentity;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
    @Autowired
     StudentService studentService;

    @PostMapping("/postdata")
    public Stuentity postdata(@RequestBody Stuentity student){
        return studentService.saveStudent(student);
    }
    @GetMapping("/get")
    public List<Stuentity> getData(){
        return studentService.getAll();
    }
  
    @GetMapping("/get/{id}")
     public Optional<Stuentity> get(@PathVariable Long id){
        return studentService.getId(id);
     }
     @PutMapping("/update/{id}")
     public Stuentity update(@PathVariable Long id,@RequestBody Stuentity st){
        return studentService.updateById(id,st);
     }
     @DeleteMapping("/delete")
     public String delete(){
        return studentService.delete();

     }

}