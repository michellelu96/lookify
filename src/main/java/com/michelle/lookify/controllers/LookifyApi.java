package com.michelle.lookify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.michelle.lookify.models.Lookify;
import com.michelle.lookify.services.LookifyService;

@RestController
public class LookifyApi {
	
	@Autowired
	private LookifyService lookifyService;
	
	public LookifyApi(LookifyService lookifyService) {
		this.lookifyService = lookifyService;
	}
	
	//get all
	@GetMapping("/api/lookify")
	public List<Lookify> findAll(){
		return lookifyService.allSongs();
	}
	
	//get one
	@GetMapping("/api/lookify/{id}")
	public Lookify oneSong(@PathVariable("id") Long id) {
		return lookifyService.findSong(id);
	}
	
	//create one
	@PostMapping("/api/lookify")
	public Lookify createOne(@RequestParam("songName") String songName,
			@RequestParam("artist") String artist,
			@RequestParam("rating") Integer rating
			) {
			Lookify newLookify = new Lookify(songName,artist,rating);
			return lookifyService.createSong(newLookify);
	}
	
	//update one
	@PutMapping("/api/lookify/{id}")
	public Lookify updateSong(@PathVariable("id") Long id,
			@RequestParam("songName") String songName,
			@RequestParam("artist") String artist,
			@RequestParam("rating") Integer rating
			) {
		Lookify updateLookify = lookifyService.findSong(id);
		updateLookify.setSongName(songName);
		updateLookify.setArtist(artist);
		updateLookify.setRating(rating);
		return lookifyService.updateSong(updateLookify);
	}
	
	//delete one
	@DeleteMapping("/api/lookify/{id}")
	public void deleteOne(@PathVariable("id") Long id) {
		lookifyService.deleteSong(id);
	}

	
}
