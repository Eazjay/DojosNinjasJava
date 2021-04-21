package com.codingdojo.dojoninjas.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.codingdojo.dojoninjas.models.Dojo;
import com.codingdojo.dojoninjas.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	public List<Dojo> allDojos(){
		return dojoRepository.findAll();
	}
	
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalD = dojoRepository.findById(id);
		if(optionalD.isPresent()) {
			return optionalD.get();
		}
		else {
			return null;
		}
	}
	
	
	public Dojo createDojo(Dojo d) {
		return dojoRepository.save(d);
	}
	
	
	public void deleteDojo(Long id) {
		Dojo d = findDojo(id);
		dojoRepository.delete(d);
	}
	
	public Dojo updateDojo(Dojo d) {
		return dojoRepository.save(d);
	}
}
