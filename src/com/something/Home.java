package com.something;

public class Home {


	private Boolean personHome;

	public Home() {
		personHome = true;
	}

	public boolean knock() {
		return personHome;
	}

	public void convertPerson() {
		personHome = false;
	}
}
