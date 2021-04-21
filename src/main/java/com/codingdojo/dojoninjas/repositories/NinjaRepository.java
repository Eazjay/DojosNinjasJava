package com.codingdojo.dojoninjas.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojoninjas.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long>{	
	
	List<Ninja> findAll();
	
	Optional<Ninja> findById(Long id);
	
	Long deleteByIdStartingWith(String search);
	
	Ninja save(Ninja ninja);
}