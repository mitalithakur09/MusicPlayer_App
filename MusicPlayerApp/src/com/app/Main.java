package com.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
  private static ArrayList<Albums> albums = new ArrayList<>();
	public static void main(String[] args) {
		Albums album = new Albums("Album1", "ACD");
		album.addSong("TNT", 4.5);
		album.addSong("TNN", 3.5);
		album.addSong("NNT", 5.5);
		
		albums.add(album);
		
	    album = new Albums("Album2", "ABCD");
		album.addSong("TNTT", 4.5);
		album.addSong("TNNN", 3.5);
		album.addSong("NNTT", 5.5);
		
		albums.add(album);
		
		LinkedList<Song> playlist1 = new LinkedList<>();
		
		albums.get(0).addToPlaylist("INT", playlist1);
		albums.get(0).addToPlaylist("TNN", playlist1);
		albums.get(1).addToPlaylist("TNTT", playlist1);
		albums.get(1).addToPlaylist("NNTT", playlist1);
		
		play(playlist1);
	}
	
	private static void play(LinkedList<Song> playList) {
		Scanner sc = new Scanner(System.in);
		boolean quit = false;
		boolean forward = true;
		ListIterator<Song> listiterator = playList.listIterator();
		
		if(playList.size()==0) {
			System.out.println("this playlist have no song");
		}
		else {
			System.out.println("Now playing " + listiterator.next().toString());
			printMenu();
		}
		
		while(!quit) {
			int action = sc.nextInt();
			switch(action) {
			case 0:
			System.out.println("Playlist complete");
			quit = true;
			break;
			
			case 1:
				if(!forward) {
					if(listiterator.hasNext()) {
						listiterator.next();
					}
					forward = true;
				}
				if(listiterator.hasNext()) {
					System.out.println("Now playing " +listiterator.next().toString());
				}
				else {
					System.out.println("no song available");
					forward = false;
				}
				break;
			case 2:
				if(forward) {
					if(listiterator.hasNext()){
						listiterator.previous();
					}
					forward = false;
				}
				if(listiterator.hasPrevious()) {
					System.out.println("Now playing " +listiterator.previous().toString());
				}
				else {
					System.out.println("we are at first song");
					forward = false;
			}
				break;
			case 3:
				if(forward) {
					if(listiterator.hasNext()){
						System.out.println("Now playing " +listiterator.previous().toString());
						forward = false;
					}
					else {
						System.out.println("we are stsrt of list");
					}}else {
						if(listiterator.hasNext()) {
							System.out.println("Now playing " +listiterator.next().toString());
							forward = true;
						}
						else {
							System.out.println("End of list");
						}
					}
				break;
				
			case 4:
				printList(playList);
				break;
				
			case 5:
				printMenu();
				break;
			case 6:
				if(playList.size()>0) {
					listiterator.remove();
					if(listiterator.hasNext()) {
						System.out.println("now playing "+listiterator.next().toString());
						
					}
					else {
						if(listiterator.hasPrevious())
						System.out.println("now playing "+listiterator.previous().toString());
					}
				}
				}
			}
		
	}
	
	private static void printMenu() {
		System.out.println("Available options \n");
		System.out.println("0 - to quit\n"+"1 - to play next song\n"+"2 - to play previous song\n"+"3 - to replay current song\n"+"4 - List of all song\n"
				+"5 - print all available option\n"+"6 - delete current song");
	}
	
	public static void printList(LinkedList<Song> playList) {
		Iterator<Song> iterator = playList.iterator();
		System.out.println("-----------------------");
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("-----------------------");
	}

}
