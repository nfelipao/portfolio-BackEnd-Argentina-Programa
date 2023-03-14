package com.appl.porfolio.controller;

import com.appl.porfolio.models.Skills;
import com.appl.porfolio.services.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/skills")
public class SkillsController {
    @Autowired
    private final SkillsService skillsService;

    public SkillsController(SkillsService skillsService) {
        this.skillsService = skillsService;
    }

    @GetMapping
    public ResponseEntity<List<Skills>> obtenerSkills(){
        List <Skills> skills= skillsService.buscarSkills();
        return new ResponseEntity<>(skills, HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<Skills> editarSkills(@RequestBody Skills skills){
        Skills updateSkill=skillsService.editarSkills(skills);
        return new ResponseEntity<>(updateSkill,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Skills> crearSkills(@RequestBody Skills skills){
        Skills nuevosSkills=skillsService.addSkills(skills);
        return new ResponseEntity<>(nuevosSkills, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarSkills(@PathVariable("id") Long id){
        skillsService.borrarSkills(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
