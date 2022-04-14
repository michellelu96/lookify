package com.michelle.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.michelle.lookify.models.Lookify;

public interface LookifyRepository extends CrudRepository<Lookify, Long>{
	List<Lookify> findAll();
	
	List<Lookify> findByArtist(String search);
	
	List<Lookify>findTop10ByOrderByRatingDesc();
}
