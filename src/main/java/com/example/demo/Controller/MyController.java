package com.example.demo.Controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Personas;
import com.example.demo.Service.ServicioPersonas;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@CrossOrigin
public class MyController {

	
	

	
	@Autowired
	private ServicioPersonas servicioPersonas;
	
	
	
	@PostMapping("/insertar")
	public ResponseEntity guardarUsuario(@RequestBody Personas persona) {
		

		
		return new ResponseEntity(servicioPersonas.guardarPersona(persona),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/recuperar/{id}")
	public String recuperarPersona(@PathVariable long id) {
		
		Optional<Personas> persona = servicioPersonas.recuperarPersona(id);
		
		
		return "<h1>EL USUARIO CON ID "+id+" ES:<h1>"
				+ "<h2>"+persona.get().toString()
				+ "";
		
	}
	
	
	@PutMapping("/modificar/{id}")
	public ResponseEntity modificarPersona(@PathVariable("id") long id,@RequestBody Personas persona) {
		
		
		return new ResponseEntity(servicioPersonas.modificarPersona(id,persona),HttpStatus.CREATED);
	}
	
	
	@GetMapping("borrar/{id}")
	public ResponseEntity borrarPersona(@PathVariable("id") long id) {
		
		return new ResponseEntity(servicioPersonas.borrarPersona(id),HttpStatus.CREATED);
	}
	
	
	@GetMapping("/recuperarTodos")
	
	public ResponseEntity recuperarTodos() {
		
		return new ResponseEntity(servicioPersonas.recuperarTodos(),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/query")
	public ResponseEntity ejecutar() {
		
		return new ResponseEntity(servicioPersonas.ejecutarQuery(),HttpStatus.CREATED);
	}
	
	
	
	
}
