package com.michelle.lookify.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="playlists")
public class Lookify {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 5, max=200 ,message = "Song name must be at least 5 characters")
	private String songName;
	
	@NotNull
	@Size(min=5, max=200, message ="Artist name must be at least 5 characters")
	private String artist;
	
	@NotNull
	@Min(value = 1,message ="Rating must be at least 1")
	@Max(value=10, message= "Rating must be smaller than 10")
	private Integer rating;
	
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public Lookify() {}
    public Lookify(String songName,String artist, Integer rating) {
    	this.songName = songName;
    	this.artist = artist;
    	this.rating = rating;
    }
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@PreUpdate
    protected void onUpdate(){
    	this.updatedAt = new Date();
    }
    
    @PrePersist
    protected void onCreate(){
    	this.createdAt = new Date();
    }
    
}
