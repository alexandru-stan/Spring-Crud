package com.example.demo.Service;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Model.Personas;
import com.example.demo.Repository.RepositorioPersonas;

import lombok.AllArgsConstructor;
import lombok.Data;
@Service
@Data
@AllArgsConstructor
public class ServicioPersonasImplementacion implements ServicioPersonas {

	private final RepositorioPersonas repositorioPersonas;



	public ServicioPersonasImplementacion(RepositorioPersonas repositorioPersonas) {
		super();
		this.repositorioPersonas = repositorioPersonas;
	}



	public Personas modificarPersona(long id,Personas persona){
		
		Optional<Personas> persona1 = repositorioPersonas.findById(id);
		
		if(persona1.isPresent()) {
			
			
			persona1.get().setNombre(persona.getNombre());
			persona1.get().setApellidos(persona.getApellidos());
			
			
			return repositorioPersonas.save(persona1.get());
		} else {
		
		 return null;
		}
		
	}


	@Override
	public Personas guardarPersona(Personas persona) {
		// TODO Auto-generated method stub
		return repositorioPersonas.save(persona);
	}
	
	
	@SuppressWarnings("deprecation")
	public Optional<Personas> recuperarPersona(long id) {
		
		return  repositorioPersonas.findById(id);
		
	}



	@Override
	public String borrarPersona(long id) {
		Optional<Personas> persona = null;
		try {
		persona = repositorioPersonas.findById(id);
		} catch (NoSuchElementException e) {
			
			System.out.println("NO EXISTE");
		}
		
		if(persona.isPresent()) {
		
		 repositorioPersonas.delete(persona.get());
		 return "OK";
		} else {
			return "NO ENCONTRADO";
		}
	}



	@Override
	public List <Personas> recuperarTodos() {
		
		
		List <Personas> personas = repositorioPersonas.findAll();
		
		
		return personas;
		
		
	}


	public List<Personas> ejecutarQuery(){
		
		return repositorioPersonas.queryPrueba();
		
		
	}

	public Personas encontrarTelefono(String tel) {
		
		List <Personas> personas = repositorioPersonas.findAll();
		Iterator<Personas> it = personas.iterator();
		
		
		
		while(it.hasNext()) {
			
			if(it.next().getTelefono() == tel) {
				
				
				
			}
		
			
		}
		
		
		return null;
		
	}






	


	
	
	
}
