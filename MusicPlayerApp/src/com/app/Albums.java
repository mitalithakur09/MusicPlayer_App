package com.app;

import java.util.ArrayList;
import java.util.LinkedList;

public class Albums {
    private String name;
    private String artist;
    private ArrayList<Song> songs;
	public Albums(String names, String artist) {
		super();
		this.name = name;
		this.artist = artist;
		this.songs = new ArrayList<>();;
	}
	public Albums() {
		
	}
	public Song findSong(String title) {
		for(Song checkedSong: songs) {
			if(checkedSong.getName().equals(title)) return checkedSong;
		}
		return null;
	}
    public boolean addSong(String title, double duration) {
    	if (findSong(title)==null) {
    		songs.add(new Song(title, duration));
    		System.out.println(title+ "The song is successfully added");
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public boolean addToPlaylist(int tracknumber, LinkedList<Song> Playlist) {
    	int index = tracknumber - 1;
    	if(index > 0 && index <= this.songs.size()) {
    		Playlist.add(this.songs.get(index));
    		return true;
    	}
    	System.out.println("This album does not have song with this tracknumber :"+tracknumber);
    	return false;
    }
    
    public boolean addToPlaylist(String title, LinkedList<Song> Playlist) {
    	for(Song checkedSong : this.songs) {
        if(checkedSong.getName().equals(title)) {
        	Playlist.add(checkedSong);
        	return true;
        }
      }
    	System.out.println(title+" there is no such song in album");
    	return false;
    }
}
