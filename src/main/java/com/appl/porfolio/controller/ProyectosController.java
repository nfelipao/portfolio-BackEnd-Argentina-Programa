package com.appl.porfolio.controller;

import com.appl.porfolio.models.Proyectos;
import com.appl.porfolio.services.ProyectosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/proyectos")
public class ProyectosController {
    @Autowired
    private final ProyectosService proyectosService;

    public ProyectosController(ProyectosService proyectosService) {
        this.proyectosService = proyectosService;
    }
    @GetMapping
    public ResponseEntity<List<Proyectos>> obtenerProyectos(){
        List <Proyectos> proyectos= proyectosService.buscarProyectos();
        return new ResponseEntity<>(proyectos, HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<Proyectos> editarProyectos(@RequestBody Proyectos proyectos){
        Proyectos updateProyectos=proyectosService.editarProyectos(proyectos);
        return new ResponseEntity<>(updateProyectos,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Proyectos> crearProyectos(@RequestBody Proyectos proyectos){
        Proyectos nuevoProyecto=proyectosService.addProyectos(proyectos);
        return new ResponseEntity<>(nuevoProyecto, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarProyectos(@PathVariable("id") Long id){
        proyectosService.borrarProyectos(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
