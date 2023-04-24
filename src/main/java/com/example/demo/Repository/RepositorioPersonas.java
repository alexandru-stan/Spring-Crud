package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Model.Personas;
import com.example.demo.Service.Queries;

public interface RepositorioPersonas extends JpaRepository<Personas,Long> {

	
	@Query(value="SELECT * FROM PERSONAS WHERE ID = 2",nativeQuery=true)
	List<Personas> queryPrueba();
	
	
	
	
}
