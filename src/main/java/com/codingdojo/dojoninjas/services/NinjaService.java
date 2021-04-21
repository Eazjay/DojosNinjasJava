package com.codingdojo.dojoninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.codingdojo.dojoninjas.models.Ninja;
import com.codingdojo.dojoninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public List<Ninja> allNinjas(){
		return ninjaRepository.findAll();
	}
	
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalN = ninjaRepository.findById(id);
		if(optionalN.isPresent()) {
			return optionalN.get();
		}
		else {
			return null;
		}
	}
	
	
	public Ninja createNinja(Ninja n) {
		return ninjaRepository.save(n);
	}
	
	
	public void deleteNinja(Long id) {
		Ninja n = findNinja(id);
		ninjaRepository.delete(n);
	}
	
	public Ninja updateNinja(Ninja n) {
		return ninjaRepository.save(n);
	}
}

