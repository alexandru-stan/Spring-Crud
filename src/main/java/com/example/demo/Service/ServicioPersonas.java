package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.Model.Personas;

public interface ServicioPersonas {

	
	
	Personas guardarPersona(Personas usuario);
	Optional<Personas> recuperarPersona(long id);
	Personas modificarPersona(long id, Personas persona);
	String borrarPersona(long id);
	List<Personas> recuperarTodos();
	List<Personas> ejecutarQuery();
	Personas encontrarTelefono(String tel);
	

}
