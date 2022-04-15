package com.michelle.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michelle.lookify.models.Lookify;
import com.michelle.lookify.repositories.LookifyRepository;

@Service
public class LookifyService {
	
	@Autowired
	private LookifyRepository lookifyRepository;
	
	public List<Lookify> allSongs(){
		return lookifyRepository.findAll();
	}
	
	public Lookify createSong(Lookify lookify) {
		return lookifyRepository.save(lookify);
	}
	
	public Lookify findSong(Long id) {
		Optional <Lookify> optionalLookify = lookifyRepository.findById(id);
		if(optionalLookify.isPresent()) {
			return optionalLookify.get();
		}else {
			return null;
		}
	}
	
	public Lookify updateSong(Lookify lookify) {
		return lookifyRepository.save(lookify);
	}
	
	public void deleteSong(Long id) {
		lookifyRepository.deleteById(id);
	}
	
	public List<Lookify> getByArtist(String search){
		return lookifyRepository.findByArtistContaining(search);
	}
	
	public List<Lookify> getByRating(){
		return lookifyRepository.findTop10ByOrderByRatingDesc();
	}
}
