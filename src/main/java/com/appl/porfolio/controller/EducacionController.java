package com.appl.porfolio.controller;

import com.appl.porfolio.models.Educacion;
import com.appl.porfolio.services.EducacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/educacion")
public class EducacionController {
    @Autowired
    private final EducacionService educacionService;

    public EducacionController(EducacionService educacionService) {
        this.educacionService = educacionService;
    }
    @GetMapping
    public ResponseEntity <List<Educacion>> obtenerEducacion(){
        List <Educacion> educaciones= educacionService.buscarEducaciones();
        return new ResponseEntity<>(educaciones, HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<Educacion> editarEducacion(@RequestBody Educacion educacion){
        Educacion updateEducacion=educacionService.editarEducacion(educacion);
        return new ResponseEntity<>(updateEducacion,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Educacion> crearEducacion(@RequestBody Educacion educacion){
        Educacion nuevaEducacion=educacionService.addEducacion(educacion);
        return new ResponseEntity<>(nuevaEducacion, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarEducacion(@PathVariable("id") Long id){
        educacionService.borrarEducacion(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
