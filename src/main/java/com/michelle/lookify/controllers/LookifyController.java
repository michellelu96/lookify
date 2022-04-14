package com.michelle.lookify.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.michelle.lookify.models.Lookify;
import com.michelle.lookify.services.LookifyService;

@Controller
public class LookifyController {
	@Autowired
	private LookifyService lookifyService;
	
	@GetMapping("/")
	public String welcomePage() {
		return "home.jsp";
	}
	
	@GetMapping("/dashboard")
	public String dashboardPage(Model model) {
		List<Lookify> allSongs = lookifyService.allSongs();
		model.addAttribute("songs",allSongs);
		return "dashboard.jsp";
	}
	
	//delete one
	@DeleteMapping("/songs/{id}")
	public String delete(@PathVariable("id") Long id) {
		lookifyService.deleteSong(id);
		return "redirect:/dashboard";
	}
	
	//get one
	@GetMapping("/songs/{id}")
	public String getOne(@PathVariable("id") Long id, Model model) {
		Lookify oneSong= lookifyService.findSong(id);
		model.addAttribute("song",oneSong);
		return "oneSong.jsp";
	}
	
	@GetMapping("/songs/new")
	public String createPage(@ModelAttribute("lookify") Lookify lookify) {
		return "addSong.jsp";
	}
	
	@PostMapping("/songs/new")
	public String create(@Valid @ModelAttribute("lookify") Lookify lookify, BindingResult result) {
		if(result.hasErrors()) {
			return "addSong.jsp";
		}else {
			lookifyService.createSong(lookify);
			return "redirect:/dashboard";
		}
	}
	
	   @PostMapping("/search")
	   public String searchByName(@RequestParam("artist") String artist) {			   
		   return "redirect:/search/" + artist;
	   }
	
	@RequestMapping("/search/{artist}")
	public String getByArtist(@PathVariable("artist") String artist, Model model) {
		List<Lookify> artistSongs = (ArrayList<Lookify>) lookifyService.getByArtist(artist);
		model.addAttribute("artist" , artist);
		model.addAttribute("artistSongs",artistSongs);
		return "search.jsp";
	}
	
	@GetMapping("search/topTen")
	public String getTopTen(Model model) {
		List<Lookify> topTen = lookifyService.getByRating();
		model.addAttribute("topTen",topTen);
		return "topTen.jsp";
		}
}
