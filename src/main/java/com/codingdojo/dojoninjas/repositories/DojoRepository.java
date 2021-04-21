package com.codingdojo.dojoninjas.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.codingdojo.dojoninjas.models.Dojo;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long>{	
	
	List<Dojo> findAll();
	
	Optional<Dojo> findById(Long id);
	
	Long deleteByIdStartingWith(String search);
	
	Dojo save(Dojo dojo);
}
