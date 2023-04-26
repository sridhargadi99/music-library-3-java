/*
 * 
 * You can use the following import statements
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 *
 */

// Write your code here
package com.example.song.controller;

import com.example.song.model.Song;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.song.service.SongJpaService;

@RestController
public class SongController{

    @Autowired
    private SongJpaService service;

    @GetMapping("/songs")
    public ArrayList<Song> allSongs(){
        return service.allSongs();
    }

    @PostMapping("/songs")
    public Song addSong(@RequestBody Song song){
        return service.addSong(song);
    }

    @GetMapping("/songs/{songId}")
    public Song getSong(@PathVariable("songId") int songId){
        return service.getSong(songId);
    }

    @PutMapping("/songs/{songId}")
    public Song updateSong(@PathVariable("songId") int songId, @RequestBody Song song){
        return service.updateSong(songId, song);
    }

    @DeleteMapping("/songs/{songId}")
    public void deleteSong(@PathVariable("songId") int songId){
        service.deleteSong(songId);
    }
    
}