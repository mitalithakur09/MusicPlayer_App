package com.app;

public class Song {
	String name;
    double duration;
	public Song() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Song(String name, double duration) {
		super();
		this.name = name;
		this.duration = duration;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "Song [name=" + name + ", duration=" + duration + ", getName()=" + getName() + ", getDuration()="
				+ getDuration() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
    
}
